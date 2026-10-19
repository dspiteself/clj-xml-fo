(ns
 org.w3.www.1999.XSL.Format.leader_length_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  :string
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
