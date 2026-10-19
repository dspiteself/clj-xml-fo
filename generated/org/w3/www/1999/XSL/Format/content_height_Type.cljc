(ns
 org.w3.www.1999.XSL.Format.content_height_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:and [:enum "auto"] :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and [:enum "scale-to-fit"] :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:re "[\\+\\-]?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)"]
  [:re "[\\+\\-]?\\d+\\.?\\d*%"]
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
