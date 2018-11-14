/**
 * H2GIS is a library that brings spatial support to the H2 Database Engine
 * <http://www.h2database.com>. H2GIS is developed by CNRS
 * <http://www.cnrs.fr/>.
 *
 * This code is part of the H2GIS project. H2GIS is free software; 
 * you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation;
 * version 3.0 of the License.
 *
 * H2GIS is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details <http://www.gnu.org/licenses/>.
 *
 *
 * For more information, please consult: <http://www.h2gis.org/>
 * or contact directly: info_at_h2gis.org
 */

package org.h2gis.functions.spatial.predicates;

import org.h2gis.api.DeterministicScalarFunction;
import org.locationtech.jts.geom.Geometry;

/**
 * Return true if the geometry A touches the geometry B
 * @author Nicolas Fortin
 */
public class ST_Touches extends DeterministicScalarFunction {

    /**
     * Default constructor
     */
    public ST_Touches() {
        addProperty(PROP_REMARKS, "Return true if the geometry A touches the geometry B.");
    }

    @Override
    public String getJavaStaticMethod() {
        return "geomTouches";
    }

    /**
     * Return true if the geometry A touches the geometry B
     * @param a Geometry Geometry.
     * @param b Geometry instance
     * @return true if the geometry A touches the geometry B
     */
    public static Boolean geomTouches(Geometry a,Geometry b) {
        if(a==null || b==null) {
            return null;
        }
        return a.touches(b);
    }
}
