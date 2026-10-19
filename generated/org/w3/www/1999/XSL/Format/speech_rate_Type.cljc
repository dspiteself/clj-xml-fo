(ns
 org.w3.www.1999.XSL.Format.speech_rate_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:and
   [:enum
    "x-slow"
    "slow"
    "medium"
    "fast"
    "x-fast"
    "faster"
    "slower"
    "inherit"]
   :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and [:re "[\\+\\-]?\\d+"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
