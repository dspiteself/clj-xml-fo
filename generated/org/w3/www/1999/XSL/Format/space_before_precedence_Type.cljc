(ns
 org.w3.www.1999.XSL.Format.space_before_precedence_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:and [:re "[\\+\\-]?\\d+"] :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and [:enum "force"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
