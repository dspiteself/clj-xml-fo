(ns
 org.w3.www.1999.XSL.Format.line_height_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:and [:enum "normal"] :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:re "[\\+\\-]?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)"]
  [:and [:re "[\\+\\-]?\\d+"] :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:re "[\\+\\-]?\\d+\\.?\\d*%"]
  [:re
   "([ ]?\\+?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)){1,3}( \\+?\\d+| force)?( retain| discard)?"]
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
