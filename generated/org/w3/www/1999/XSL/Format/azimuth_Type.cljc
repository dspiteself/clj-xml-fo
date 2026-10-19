(ns
 org.w3.www.1999.XSL.Format.azimuth_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:re "[\\+\\-]?[1-3]?\\d?\\d?\\.?\\d*(deg|grad|rad)"]
  [:and
   [:enum
    "left-side"
    "far-left"
    "left"
    "center-left"
    "center"
    "center-right"
    "right"
    "far-right"
    "right-side"
    "behind"
    "leftwards"
    "rightwards"
    "inherit"]
   :org.w3.www.2001.XMLSchema/NMTOKEN]])
