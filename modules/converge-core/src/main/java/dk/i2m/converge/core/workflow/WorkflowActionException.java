/*
 *  Copyright (C) 2010 Interactive Media Management
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.i2m.converge.core.workflow;

/**
 * Exception thrown if a problem arises with a WorkflowAction.
 *
 * @author Allan Lykke Christensen
 */
public class WorkflowActionException extends Exception {

    public WorkflowActionException(Throwable cause) {
        super(cause);
    }

    public WorkflowActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkflowActionException(String message) {
        super(message);
    }

    public WorkflowActionException() {
        super();
    }
}
