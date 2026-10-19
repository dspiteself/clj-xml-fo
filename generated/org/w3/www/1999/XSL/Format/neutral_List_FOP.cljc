(ns
 org.w3.www.1999.XSL.Format.neutral_List_FOP
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def
 deps
 #{:org.w3.www.1999.XSL.Format/auto_restore_Type
   :org.w3.www.1999.XSL.Format/background_Type
   :org.w3.www.1999.XSL.Format/border_collapse_Type
   :org.w3.www.1999.XSL.Format/border_color_Type
   :org.w3.www.1999.XSL.Format/border_margin_width_Type
   :org.w3.www.1999.XSL.Format/border_multi_style_Type
   :org.w3.www.1999.XSL.Format/border_side_Type
   :org.w3.www.1999.XSL.Format/caption_side_Type
   :org.w3.www.1999.XSL.Format/color_Type
   :org.w3.www.1999.XSL.Format/country_Type
   :org.w3.www.1999.XSL.Format/direction_Type
   :org.w3.www.1999.XSL.Format/displace_Type
   :org.w3.www.1999.XSL.Format/display_align_Type
   :org.w3.www.1999.XSL.Format/empty_cells_Type
   :org.w3.www.1999.XSL.Format/end_indent_Type
   :org.w3.www.1999.XSL.Format/family_name_Type
   :org.w3.www.1999.XSL.Format/font_selection_strategy_Type
   :org.w3.www.1999.XSL.Format/font_size_Type
   :org.w3.www.1999.XSL.Format/font_size_adjust_Type
   :org.w3.www.1999.XSL.Format/font_style_Type
   :org.w3.www.1999.XSL.Format/font_variant_Type
   :org.w3.www.1999.XSL.Format/font_weight_Type
   :org.w3.www.1999.XSL.Format/hyphenate_Type
   :org.w3.www.1999.XSL.Format/hyphenation_character_Type
   :org.w3.www.1999.XSL.Format/hyphenation_keep_Type
   :org.w3.www.1999.XSL.Format/hyphenation_ladder_count_Type
   :org.w3.www.1999.XSL.Format/integer_Type
   :org.w3.www.1999.XSL.Format/keep_compound_Type
   :org.w3.www.1999.XSL.Format/keep_integer_Type
   :org.w3.www.1999.XSL.Format/language_Type
   :org.w3.www.1999.XSL.Format/last_line_end_indent_Type
   :org.w3.www.1999.XSL.Format/leader_alignment_Type
   :org.w3.www.1999.XSL.Format/leader_length_Type
   :org.w3.www.1999.XSL.Format/leader_pattern_Type
   :org.w3.www.1999.XSL.Format/leader_pattern_width_Type
   :org.w3.www.1999.XSL.Format/length_Type
   :org.w3.www.1999.XSL.Format/length_bp_ip_direction_Type
   :org.w3.www.1999.XSL.Format/length_percentage_Type
   :org.w3.www.1999.XSL.Format/letter_spacing_Type
   :org.w3.www.1999.XSL.Format/line_height_Type
   :org.w3.www.1999.XSL.Format/line_height_shift_adjustment_Type
   :org.w3.www.1999.XSL.Format/line_stacking_strategy_Type
   :org.w3.www.1999.XSL.Format/linefeed_treatment_Type
   :org.w3.www.1999.XSL.Format/max_width_Type
   :org.w3.www.1999.XSL.Format/orientation_Type
   :org.w3.www.1999.XSL.Format/orphans_Type
   :org.w3.www.1999.XSL.Format/page_break_inside_Type
   :org.w3.www.1999.XSL.Format/position_Type
   :org.w3.www.1999.XSL.Format/provisional_distance_between_starts_Type
   :org.w3.www.1999.XSL.Format/provisional_label_separation_Type
   :org.w3.www.1999.XSL.Format/relative_align_Type
   :org.w3.www.1999.XSL.Format/retrieve_boundary_Type
   :org.w3.www.1999.XSL.Format/retrieve_position_Type
   :org.w3.www.1999.XSL.Format/rule_style_Type
   :org.w3.www.1999.XSL.Format/score_spaces_Type
   :org.w3.www.1999.XSL.Format/start_indent_Type
   :org.w3.www.1999.XSL.Format/text_align_Type
   :org.w3.www.1999.XSL.Format/text_align_last_Type
   :org.w3.www.1999.XSL.Format/text_transform_Type
   :org.w3.www.1999.XSL.Format/visibility_Type
   :org.w3.www.1999.XSL.Format/white_space_Type
   :org.w3.www.1999.XSL.Format/white_space_collapse_Type
   :org.w3.www.1999.XSL.Format/white_space_treatment_Type
   :org.w3.www.1999.XSL.Format/widows_Type
   :org.w3.www.1999.XSL.Format/wrap_option_Type
   :org.w3.www.1999.XSL.Format/writing_mode_Type
   :org.w3.www.2001.XMLSchema/string})
(def
 sch
 [:or
  [:tuple
   [:enum :wrapper]
   [:map
    {:closed true, :xml/value-wrapped true}
    [:auto-restore
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/auto_restore_Type]]
    [:background
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_Type]]
    [:border-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_collapse_Type]]
    [:border-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_color_Type]]
    [:border-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-separation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_bp_ip_direction_Type]]
    [:border-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_multi_style_Type]]
    [:border-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:caption-side
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/caption_side_Type]]
    [:color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:country
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/country_Type]]
    [:direction
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/direction_Type]]
    [:display-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/display_align_Type]]
    [:empty-cells
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/empty_cells_Type]]
    [:end-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/end_indent_Type]]
    [:font
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:font-family
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/family_name_Type]]
    [:font-selection-strategy
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_selection_strategy_Type]]
    [:font-size
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_size_Type]]
    [:font-size-adjust
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_size_adjust_Type]]
    [:font-stretch
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:font-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_style_Type]]
    [:font-variant
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_variant_Type]]
    [:font-weight
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_weight_Type]]
    [:glyph-orientation-horizontal
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:glyph-orientation-vertical
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:hyphenate
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenate_Type]]
    [:hyphenation-character
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_character_Type]]
    [:hyphenation-keep
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_keep_Type]]
    [:hyphenation-ladder-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_ladder_count_Type]]
    [:hyphenation-push-character-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Type]]
    [:hyphenation-remain-character-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Type]]
    [:id
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:intrusion-displace
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/displace_Type]]
    [:keep-together
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_compound_Type]]
    [:keep-together.within-column
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-together.within-line
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-together.within-page
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:language
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/language_Type]]
    [:last-line-end-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/last_line_end_indent_Type]]
    [:leader-alignment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_alignment_Type]]
    [:leader-length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_length_Type]]
    [:leader-length.maximum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-length.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-length.optimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-pattern
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_pattern_Type]]
    [:leader-pattern-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_pattern_width_Type]]
    [:letter-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:line-height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/line_height_Type]]
    [:line-height-shift-adjustment
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/line_height_shift_adjustment_Type]]
    [:line-stacking-strategy
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/line_stacking_strategy_Type]]
    [:linefeed-treatment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/linefeed_treatment_Type]]
    [:margin
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:max-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/max_width_Type]]
    [:min-height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:min-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:orphans
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orphans_Type]]
    [:page-break-inside
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/page_break_inside_Type]]
    [:position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/position_Type]]
    [:provisional-distance-between-starts
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/provisional_distance_between_starts_Type]]
    [:provisional-label-separation
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/provisional_label_separation_Type]]
    [:reference-orientation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:relative-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/relative_align_Type]]
    [:rule-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/rule_style_Type]]
    [:rule-thickness
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:score-spaces
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/score_spaces_Type]]
    [:script
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:start-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:text-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_align_Type]]
    [:text-align-last
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_align_last_Type]]
    [:text-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_percentage_Type]]
    [:text-transform
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_transform_Type]]
    [:visibility
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/visibility_Type]]
    [:white-space
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_Type]]
    [:white-space-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_collapse_Type]]
    [:white-space-treatment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_treatment_Type]]
    [:widows
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/widows_Type]]
    [:word-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:wrap-option
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/wrap_option_Type]]
    [:writing-mode
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/writing_mode_Type]]
    [:xml/value :xml/hiccup]]]
  [:tuple
   [:enum :retrieve-marker]
   [:map
    {:closed true}
    [:auto-restore
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/auto_restore_Type]]
    [:background
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_Type]]
    [:border-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_collapse_Type]]
    [:border-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_color_Type]]
    [:border-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-separation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_bp_ip_direction_Type]]
    [:border-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_multi_style_Type]]
    [:border-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:caption-side
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/caption_side_Type]]
    [:color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:country
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/country_Type]]
    [:direction
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/direction_Type]]
    [:display-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/display_align_Type]]
    [:empty-cells
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/empty_cells_Type]]
    [:end-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/end_indent_Type]]
    [:font
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:font-family
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/family_name_Type]]
    [:font-selection-strategy
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_selection_strategy_Type]]
    [:font-size
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_size_Type]]
    [:font-size-adjust
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_size_adjust_Type]]
    [:font-stretch
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:font-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_style_Type]]
    [:font-variant
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_variant_Type]]
    [:font-weight
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_weight_Type]]
    [:glyph-orientation-horizontal
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:glyph-orientation-vertical
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:hyphenate
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenate_Type]]
    [:hyphenation-character
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_character_Type]]
    [:hyphenation-keep
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_keep_Type]]
    [:hyphenation-ladder-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_ladder_count_Type]]
    [:hyphenation-push-character-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Type]]
    [:hyphenation-remain-character-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Type]]
    [:intrusion-displace
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/displace_Type]]
    [:keep-together
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_compound_Type]]
    [:keep-together.within-column
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-together.within-line
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-together.within-page
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:language
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/language_Type]]
    [:last-line-end-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/last_line_end_indent_Type]]
    [:leader-alignment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_alignment_Type]]
    [:leader-length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_length_Type]]
    [:leader-length.maximum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-length.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-length.optimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-pattern
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_pattern_Type]]
    [:leader-pattern-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_pattern_width_Type]]
    [:letter-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:line-height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/line_height_Type]]
    [:line-height-shift-adjustment
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/line_height_shift_adjustment_Type]]
    [:line-stacking-strategy
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/line_stacking_strategy_Type]]
    [:linefeed-treatment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/linefeed_treatment_Type]]
    [:margin
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:max-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/max_width_Type]]
    [:min-height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:min-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:orphans
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orphans_Type]]
    [:page-break-inside
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/page_break_inside_Type]]
    [:position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/position_Type]]
    [:provisional-distance-between-starts
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/provisional_distance_between_starts_Type]]
    [:provisional-label-separation
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/provisional_label_separation_Type]]
    [:reference-orientation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:relative-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/relative_align_Type]]
    [:retrieve-boundary
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/retrieve_boundary_Type]]
    [:retrieve-class-name
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:retrieve-position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/retrieve_position_Type]]
    [:rule-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/rule_style_Type]]
    [:rule-thickness
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:score-spaces
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/score_spaces_Type]]
    [:script
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:start-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:text-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_align_Type]]
    [:text-align-last
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_align_last_Type]]
    [:text-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_percentage_Type]]
    [:text-transform
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_transform_Type]]
    [:visibility
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/visibility_Type]]
    [:white-space
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_Type]]
    [:white-space-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_collapse_Type]]
    [:white-space-treatment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_treatment_Type]]
    [:widows
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/widows_Type]]
    [:word-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:wrap-option
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/wrap_option_Type]]
    [:writing-mode
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/writing_mode_Type]]]]])
(def
 sch-seq
 [:alt
  [:tuple
   [:enum :wrapper]
   [:map
    {:closed true, :xml/value-wrapped true}
    [:auto-restore
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/auto_restore_Type]]
    [:background
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_Type]]
    [:border-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_collapse_Type]]
    [:border-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_color_Type]]
    [:border-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-separation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_bp_ip_direction_Type]]
    [:border-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_multi_style_Type]]
    [:border-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:caption-side
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/caption_side_Type]]
    [:color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:country
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/country_Type]]
    [:direction
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/direction_Type]]
    [:display-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/display_align_Type]]
    [:empty-cells
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/empty_cells_Type]]
    [:end-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/end_indent_Type]]
    [:font
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:font-family
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/family_name_Type]]
    [:font-selection-strategy
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_selection_strategy_Type]]
    [:font-size
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_size_Type]]
    [:font-size-adjust
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_size_adjust_Type]]
    [:font-stretch
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:font-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_style_Type]]
    [:font-variant
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_variant_Type]]
    [:font-weight
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_weight_Type]]
    [:glyph-orientation-horizontal
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:glyph-orientation-vertical
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:hyphenate
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenate_Type]]
    [:hyphenation-character
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_character_Type]]
    [:hyphenation-keep
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_keep_Type]]
    [:hyphenation-ladder-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_ladder_count_Type]]
    [:hyphenation-push-character-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Type]]
    [:hyphenation-remain-character-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Type]]
    [:id
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:intrusion-displace
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/displace_Type]]
    [:keep-together
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_compound_Type]]
    [:keep-together.within-column
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-together.within-line
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-together.within-page
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:language
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/language_Type]]
    [:last-line-end-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/last_line_end_indent_Type]]
    [:leader-alignment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_alignment_Type]]
    [:leader-length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_length_Type]]
    [:leader-length.maximum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-length.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-length.optimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-pattern
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_pattern_Type]]
    [:leader-pattern-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_pattern_width_Type]]
    [:letter-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:line-height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/line_height_Type]]
    [:line-height-shift-adjustment
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/line_height_shift_adjustment_Type]]
    [:line-stacking-strategy
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/line_stacking_strategy_Type]]
    [:linefeed-treatment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/linefeed_treatment_Type]]
    [:margin
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:max-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/max_width_Type]]
    [:min-height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:min-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:orphans
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orphans_Type]]
    [:page-break-inside
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/page_break_inside_Type]]
    [:position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/position_Type]]
    [:provisional-distance-between-starts
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/provisional_distance_between_starts_Type]]
    [:provisional-label-separation
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/provisional_label_separation_Type]]
    [:reference-orientation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:relative-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/relative_align_Type]]
    [:rule-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/rule_style_Type]]
    [:rule-thickness
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:score-spaces
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/score_spaces_Type]]
    [:script
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:start-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:text-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_align_Type]]
    [:text-align-last
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_align_last_Type]]
    [:text-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_percentage_Type]]
    [:text-transform
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_transform_Type]]
    [:visibility
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/visibility_Type]]
    [:white-space
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_Type]]
    [:white-space-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_collapse_Type]]
    [:white-space-treatment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_treatment_Type]]
    [:widows
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/widows_Type]]
    [:word-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:wrap-option
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/wrap_option_Type]]
    [:writing-mode
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/writing_mode_Type]]
    [:xml/value :xml/hiccup]]]
  [:tuple
   [:enum :retrieve-marker]
   [:map
    {:closed true}
    [:auto-restore
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/auto_restore_Type]]
    [:background
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_Type]]
    [:border-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_collapse_Type]]
    [:border-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_color_Type]]
    [:border-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-separation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_bp_ip_direction_Type]]
    [:border-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_multi_style_Type]]
    [:border-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:caption-side
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/caption_side_Type]]
    [:color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:country
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/country_Type]]
    [:direction
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/direction_Type]]
    [:display-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/display_align_Type]]
    [:empty-cells
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/empty_cells_Type]]
    [:end-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/end_indent_Type]]
    [:font
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:font-family
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/family_name_Type]]
    [:font-selection-strategy
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_selection_strategy_Type]]
    [:font-size
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_size_Type]]
    [:font-size-adjust
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_size_adjust_Type]]
    [:font-stretch
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:font-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_style_Type]]
    [:font-variant
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_variant_Type]]
    [:font-weight
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/font_weight_Type]]
    [:glyph-orientation-horizontal
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:glyph-orientation-vertical
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:hyphenate
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenate_Type]]
    [:hyphenation-character
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_character_Type]]
    [:hyphenation-keep
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_keep_Type]]
    [:hyphenation-ladder-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/hyphenation_ladder_count_Type]]
    [:hyphenation-push-character-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Type]]
    [:hyphenation-remain-character-count
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Type]]
    [:intrusion-displace
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/displace_Type]]
    [:keep-together
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_compound_Type]]
    [:keep-together.within-column
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-together.within-line
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-together.within-page
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:language
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/language_Type]]
    [:last-line-end-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/last_line_end_indent_Type]]
    [:leader-alignment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_alignment_Type]]
    [:leader-length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_length_Type]]
    [:leader-length.maximum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-length.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-length.optimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:leader-pattern
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_pattern_Type]]
    [:leader-pattern-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/leader_pattern_width_Type]]
    [:letter-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:line-height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/line_height_Type]]
    [:line-height-shift-adjustment
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/line_height_shift_adjustment_Type]]
    [:line-stacking-strategy
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/line_stacking_strategy_Type]]
    [:linefeed-treatment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/linefeed_treatment_Type]]
    [:margin
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:max-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/max_width_Type]]
    [:min-height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:min-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:orphans
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orphans_Type]]
    [:page-break-inside
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/page_break_inside_Type]]
    [:position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/position_Type]]
    [:provisional-distance-between-starts
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/provisional_distance_between_starts_Type]]
    [:provisional-label-separation
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/provisional_label_separation_Type]]
    [:reference-orientation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/orientation_Type]]
    [:relative-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/relative_align_Type]]
    [:retrieve-boundary
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/retrieve_boundary_Type]]
    [:retrieve-class-name
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:retrieve-position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/retrieve_position_Type]]
    [:rule-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/rule_style_Type]]
    [:rule-thickness
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:score-spaces
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/score_spaces_Type]]
    [:script
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:start-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:text-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_align_Type]]
    [:text-align-last
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_align_last_Type]]
    [:text-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_percentage_Type]]
    [:text-transform
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/text_transform_Type]]
    [:visibility
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/visibility_Type]]
    [:white-space
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_Type]]
    [:white-space-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_collapse_Type]]
    [:white-space-treatment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/white_space_treatment_Type]]
    [:widows
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/widows_Type]]
    [:word-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:wrap-option
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/wrap_option_Type]]
    [:writing-mode
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/writing_mode_Type]]]]])
