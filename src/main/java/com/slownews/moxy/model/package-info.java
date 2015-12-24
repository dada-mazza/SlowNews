@XmlSchema(
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {@XmlNs(prefix = "media", namespaceURI = "http://search.yahoo.com/mrss/")}
)
package com.slownews.moxy.model;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;