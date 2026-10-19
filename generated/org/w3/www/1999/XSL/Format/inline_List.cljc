(ns
 org.w3.www.1999.XSL.Format.inline_List
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def
 deps
 #{:org.w3.www.1999.XSL.Format/inline_List_FOP
   :org.w3.www.1999.XSL.Format/inline_List_FOP-seq
   :org.w3.www.1999.XSL.Format/inline_List_Not
   :org.w3.www.1999.XSL.Format/inline_List_Not-seq})
(def
 sch
 [:or
  [:ref :org.w3.www.1999.XSL.Format/inline_List_FOP]
  [:ref :org.w3.www.1999.XSL.Format/inline_List_Not]])
(def
 sch-seq
 [:alt
  [:ref :org.w3.www.1999.XSL.Format/inline_List_FOP-seq]
  [:ref :org.w3.www.1999.XSL.Format/inline_List_Not-seq]])
