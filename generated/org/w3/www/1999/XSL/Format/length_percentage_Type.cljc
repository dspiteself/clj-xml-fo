(ns
 org.w3.www.1999.XSL.Format.length_percentage_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{})
(def
 sch
 [:or
  [:re "[\\+\\-]?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)"]
  [:re "[\\+\\-]?\\d+\\.?\\d*%"]])
