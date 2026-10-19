(ns
 org.w3.www.1999.XSL.Format.padding_top_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:and
   [:enum "thin" "medium" "thick"]
   :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:re "[\\+\\-]?\\d+\\.?\\d*(px|pt|mm|cm|in|em|%)"]
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
