(ns
 org.w3.www.1999.XSL.Format.background_position_horizontal_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:re "[\\+\\-]?\\d+\\.?\\d*%"]
  [:re "[\\+\\-]?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)"]
  [:and
   [:enum "left" "center" "right"]
   :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
