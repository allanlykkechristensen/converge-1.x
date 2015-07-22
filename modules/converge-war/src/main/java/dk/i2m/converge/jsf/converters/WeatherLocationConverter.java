/*
 * Copyright (C) 2010 Interactive Media Management
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.i2m.converge.jsf.converters;

import dk.i2m.converge.core.content.weather.Location;
import dk.i2m.converge.ejb.facades.ListingFacadeLocal;
import dk.i2m.converge.core.DataNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Allan Lykke Christensen
 */
public class WeatherLocationConverter implements Converter {

    private static final Logger LOG = Logger.getLogger(WeatherLocationConverter.class.getName());

    private final ListingFacadeLocal facade;

    public WeatherLocationConverter(ListingFacadeLocal facade) {
        this.facade = facade;
    }

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value == null) {
            return null;
        }

        try {
            return facade.findWeatherLocationById(Long.valueOf(value));
        } catch (DataNotFoundException ex) {
            LOG.log(Level.WARNING, "No matching weather location", ex);
            return null;
        } catch (NumberFormatException ex) {
            LOG.log(Level.SEVERE, "Invalid object passed to Converter. Expected Long object received {0} ({1})", new Object[]{value.getClass(), value});
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        Location obj = (Location) value;
        if (obj == null) {
            return "";
        } else {
            if (obj.getId() == null) {
                LOG.log(Level.SEVERE, "Location does not exist in database");
                return null;
            } else {
                return String.valueOf(obj.getId());
            }
        }
    }
}
