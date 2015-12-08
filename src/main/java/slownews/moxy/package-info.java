@XmlSchema(
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {@XmlNs(prefix = "media", namespaceURI = "http://search.yahoo.com/mrss/")}
)
package slownews.moxy;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;