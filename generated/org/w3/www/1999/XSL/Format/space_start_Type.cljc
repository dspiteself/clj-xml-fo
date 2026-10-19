(ns
 org.w3.www.1999.XSL.Format.space_start_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:re
   "([ ]?\\+?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)){1,3}( \\+?\\d+| force)?( retain| discard)?"]
  [:re "[\\+\\-]?\\d+\\.?\\d*%"]
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
