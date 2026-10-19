(ns
 org.w3.www.1999.XSL.Format.alignment_baseline_Type
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def deps #{:org.w3.www.2001.XMLSchema/NMTOKEN})
(def
 sch
 [:or
  [:and [:enum "auto"] :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and
   [:enum
    "baseline"
    "before-edge"
    "text-before-edge"
    "middle"
    "central"
    "after-edge"
    "text-after-edge"
    "ideographic"
    "alphabetic"
    "hanging"
    "mathematical"]
   :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and
   [:enum "top" "text-top" "bottom" "text-bottom"]
   :org.w3.www.2001.XMLSchema/NMTOKEN]
  [:and [:enum "inherit"] :org.w3.www.2001.XMLSchema/NMTOKEN]])
