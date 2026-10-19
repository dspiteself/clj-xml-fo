(ns
 org.w3.www.1999.XSL.Format.hyphenation_ladder_count_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:and [:enum "no-limit"] :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and [:re "[\\+\\-]?\\d+"] :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
