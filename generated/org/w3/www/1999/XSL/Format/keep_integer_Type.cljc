(ns
 org.w3.www.1999.XSL.Format.keep_integer_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:and
  [:re "(\\+?\\d+|auto|always)"]
  :org.w3.www.2001.XMLSchema/NMTOKEN])
