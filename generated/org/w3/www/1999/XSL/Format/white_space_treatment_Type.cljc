(ns
 org.w3.www.1999.XSL.Format.white_space_treatment_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:and
  [:enum
   "ignore"
   "preserve"
   "ignore-if-before-linefeed"
   "ignore-if-after-linefeed"
   "ignore-if-surrounding-linefeed"
   "inherit"]
  :org.w3.www.2001.XMLSchema/NMTOKEN])
