/*
* =============================================================================
*
* Copyright © 2010 Allstate Roadside Services(ARS)
* All rights reserved.
*
* This program may not be duplicated, disclosed or provided to any third parties
* without the prior written consent of ARS.
* Disassembly or decompilation of the software and/or reverse engineering
* of the object code are prohibited.
*
* =============================================================================
* Purpose
* Remarks
*
* Revision History:
* When        Who           What
* -----------------------------------------------------------------------------
* Dec 15, 2010	  smaac
*
* =============================================================================
*/

package com.abiode.util;

import java.text.MessageFormat;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
//import org.apache.log4j.Logger;


/**
 * This class is used to Read value from Property files
 */
public class PropertyProvider {

   // private static Logger logger = Logger.getLogger(PropertyProvider.class);
    private MessageSource _resources;

    /**
     * Property Provider Constructor
     *
     * @param msgSource - Message Source
     */
    public PropertyProvider(MessageSource msgSource) {
        this._resources = msgSource;
        //logger.info("PropertyProvider.PropertyProvider => " + this._resources);
    }

    /**
     * @param aPKey String
     * @return String Value for a given aPKey
     * @throws DrivewiseServiceException - Error
     */
    public String getProperty(String aPKey) throws Exception {
        String value = "";
        try {
            value = _resources.getMessage(aPKey, null, null);
        } catch (NoSuchMessageException nsme) {
            //logger.error("No properties with the specified name can be found : " + aPKey, nsme);
        }
        return value;
    }

    /**
     * String Value for a given aPKey
     *
     * @param aPKey   - Key
     * @param aPParam - Local
     * @return String - Property Value
     * @throws DrivewiseServiceException - Error
     */
    public String getProperty(String aPKey, Object[] aPParam) throws Exception {
        if (aPParam != null) {
            return getProperty(aPKey, aPParam, Locale.getDefault());
        } else {
            return getProperty(aPKey);
        }
    }

    /**
     * String Value for a given aPKey
     *
     * @param aPKey    - Key
     * @param aPParam  - Value
     * @param aPLocale - Local
     * @return String - Property Value
     * @throws DrivewiseServiceException - Error
     */
    public String getProperty(String aPKey, Object[] aPParam, Locale aPLocale) throws Exception {
        String value;
        try {
            value = _resources.getMessage(aPKey, aPParam, aPLocale);
            if (aPParam != null) {
                MessageFormat mf = new MessageFormat(value, aPLocale);
                value = mf.format(aPParam, new StringBuffer(), null).toString();
            }
        } catch (NoSuchMessageException nsmEx) {
            //logger.warn("No properties with the specified name can be found : " + aPKey, nsmEx);
            return null;
        } catch (Exception ex) {
            //logger.error("Error getting message from properties Key : " + aPKey + " => " + ex.getMessage());
            throw new Exception("Error while retrieving property for aPKey : (" + aPKey + ")" + ex.getMessage());
        }
        return value;
    }

    /**
     * @return Returns the name/location of resources file
     */
    public String getResources() {
        return _resources.toString();
    }
}
