(ns
 org.w3.www.1999.XSL.Format.column_width_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{})
(def
 sch
 [:or
  [:or
   [:re "[\\+\\-]?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)"]
   [:re "[\\+\\-]?\\d+\\.?\\d*%"]]
  [:re "proportional-column-width\\(\\d+\\)"]])
