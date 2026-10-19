(ns
 org.w3.www.1999.XSL.Format.background_position_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  :string
  :string
  [:enum
   "top left"
   "top center"
   "top right"
   "center left"
   "center center"
   "center right"
   "bottom left"
   "bottom center"
   "bottom right"]
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
