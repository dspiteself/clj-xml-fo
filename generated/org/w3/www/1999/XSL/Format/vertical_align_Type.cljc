(ns
 org.w3.www.1999.XSL.Format.vertical_align_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{})
(def
 sch
 [:or
  [:enum
   "baseline"
   "middle"
   "sub"
   "super"
   "text-top"
   "text-bottom"
   "top"
   "bottom"
   "inherit"]
  [:re "[\\+\\-]?\\d+\\.?\\d*%"]
  [:re "[\\+\\-]?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)"]])
