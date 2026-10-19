(ns
 org.w3.www.1999.XSL.Format.retrieve_position_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:and
  [:enum
   "first-starting-within-page"
   "first-including-carryover"
   "last-starting-within-page"
   "last-ending-within-page"]
  :org.w3.www.2001.XMLSchema/NMTOKEN])
