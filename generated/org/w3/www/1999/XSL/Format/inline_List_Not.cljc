(ns
 org.w3.www.1999.XSL.Format.inline_List_Not
 "Generated from XSD by dunnage.sitoa.schema-namespaces. Do not edit.")
(def
 deps
 #{:org.w3.www.1999.XSL.Format/alignment_adjust_Type
   :org.w3.www.1999.XSL.Format/alignment_baseline_Type
   :org.w3.www.1999.XSL.Format/auto_restore_Type
   :org.w3.www.1999.XSL.Format/azimuth_Type
   :org.w3.www.1999.XSL.Format/background_Type
   :org.w3.www.1999.XSL.Format/background_attachment_Type
   :org.w3.www.1999.XSL.Format/background_color_Type
   :org.w3.www.1999.XSL.Format/background_position_horizontal_Type
   :org.w3.www.1999.XSL.Format/background_position_vertical_Type
   :org.w3.www.1999.XSL.Format/background_repeat_Type
   :org.w3.www.1999.XSL.Format/baseline_shift_Type
   :org.w3.www.1999.XSL.Format/block_List
   :org.w3.www.1999.XSL.Format/block_progression_dimension_maximum_Type
   :org.w3.www.1999.XSL.Format/block_progression_dimension_optimum_Type
   :org.w3.www.1999.XSL.Format/border_Type
   :org.w3.www.1999.XSL.Format/border_before_width_Type
   :org.w3.www.1999.XSL.Format/border_collapse_Type
   :org.w3.www.1999.XSL.Format/border_color_Type
   :org.w3.www.1999.XSL.Format/border_margin_width_Type
   :org.w3.www.1999.XSL.Format/border_multi_style_Type
   :org.w3.www.1999.XSL.Format/border_side_Type
   :org.w3.www.1999.XSL.Format/border_style_Type
   :org.w3.www.1999.XSL.Format/border_top_width_Type
   :org.w3.www.1999.XSL.Format/bottom_Type
   :org.w3.www.1999.XSL.Format/caption_side_Type
   :org.w3.www.1999.XSL.Format/clip_Type
   :org.w3.www.1999.XSL.Format/color_Type
   :org.w3.www.1999.XSL.Format/conditionality_Type
   :org.w3.www.1999.XSL.Format/country_Type
   :org.w3.www.1999.XSL.Format/direction_Type
   :org.w3.www.1999.XSL.Format/displace_Type
   :org.w3.www.1999.XSL.Format/display_align_Type
   :org.w3.www.1999.XSL.Format/dominant_baseline_Type
   :org.w3.www.1999.XSL.Format/elevation_Type
   :org.w3.www.1999.XSL.Format/empty_cells_Type
   :org.w3.www.1999.XSL.Format/end_indent_Type
   :org.w3.www.1999.XSL.Format/family_name_Type
   :org.w3.www.1999.XSL.Format/float_List
   :org.w3.www.1999.XSL.Format/font_selection_strategy_Type
   :org.w3.www.1999.XSL.Format/font_size_Type
   :org.w3.www.1999.XSL.Format/font_size_adjust_Type
   :org.w3.www.1999.XSL.Format/font_style_Type
   :org.w3.www.1999.XSL.Format/font_variant_Type
   :org.w3.www.1999.XSL.Format/font_weight_Type
   :org.w3.www.1999.XSL.Format/footnote_List
   :org.w3.www.1999.XSL.Format/height_Type
   :org.w3.www.1999.XSL.Format/hyphenate_Type
   :org.w3.www.1999.XSL.Format/hyphenation_character_Type
   :org.w3.www.1999.XSL.Format/hyphenation_keep_Type
   :org.w3.www.1999.XSL.Format/hyphenation_ladder_count_Type
   :org.w3.www.1999.XSL.Format/integer_Force_Type
   :org.w3.www.1999.XSL.Format/integer_Type
   :org.w3.www.1999.XSL.Format/keep_compound_Type
   :org.w3.www.1999.XSL.Format/keep_integer_Type
   :org.w3.www.1999.XSL.Format/language_Type
   :org.w3.www.1999.XSL.Format/last_line_end_indent_Type
   :org.w3.www.1999.XSL.Format/leader_alignment_Type
   :org.w3.www.1999.XSL.Format/leader_length_Type
   :org.w3.www.1999.XSL.Format/leader_pattern_Type
   :org.w3.www.1999.XSL.Format/leader_pattern_width_Type
   :org.w3.www.1999.XSL.Format/left_Type
   :org.w3.www.1999.XSL.Format/length_Type
   :org.w3.www.1999.XSL.Format/length_bp_ip_direction_Type
   :org.w3.www.1999.XSL.Format/length_percentage_Type
   :org.w3.www.1999.XSL.Format/letter_spacing_Type
   :org.w3.www.1999.XSL.Format/line_height_Type
   :org.w3.www.1999.XSL.Format/line_height_shift_adjustment_Type
   :org.w3.www.1999.XSL.Format/line_stacking_strategy_Type
   :org.w3.www.1999.XSL.Format/linefeed_treatment_Type
   :org.w3.www.1999.XSL.Format/margin_width_Type
   :org.w3.www.1999.XSL.Format/marker_List
   :org.w3.www.1999.XSL.Format/max_width_Type
   :org.w3.www.1999.XSL.Format/neutral_List
   :org.w3.www.1999.XSL.Format/orientation_Type
   :org.w3.www.1999.XSL.Format/orphans_Type
   :org.w3.www.1999.XSL.Format/overflow_Type
   :org.w3.www.1999.XSL.Format/padding_before_Type
   :org.w3.www.1999.XSL.Format/padding_top_Type
   :org.w3.www.1999.XSL.Format/page_break_inside_Type
   :org.w3.www.1999.XSL.Format/position_Type
   :org.w3.www.1999.XSL.Format/provisional_distance_between_starts_Type
   :org.w3.www.1999.XSL.Format/provisional_label_separation_Type
   :org.w3.www.1999.XSL.Format/relative_align_Type
   :org.w3.www.1999.XSL.Format/relative_position_Type
   :org.w3.www.1999.XSL.Format/right_Type
   :org.w3.www.1999.XSL.Format/rule_style_Type
   :org.w3.www.1999.XSL.Format/score_spaces_Type
   :org.w3.www.1999.XSL.Format/space_start_Type
   :org.w3.www.1999.XSL.Format/speak_numeral_Type
   :org.w3.www.1999.XSL.Format/speech_rate_Type
   :org.w3.www.1999.XSL.Format/start_indent_Type
   :org.w3.www.1999.XSL.Format/text_align_Type
   :org.w3.www.1999.XSL.Format/text_align_last_Type
   :org.w3.www.1999.XSL.Format/text_transform_Type
   :org.w3.www.1999.XSL.Format/top_Type
   :org.w3.www.1999.XSL.Format/unicode_bidi_Type
   :org.w3.www.1999.XSL.Format/vertical_align_Type
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
   [:enum :bidi-override]
   [:map
    {:closed true, :xml/value-wrapped true}
    [:auto-restore
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/auto_restore_Type]]
    [:azimuth
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/azimuth_Type]]
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
    [:bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/bottom_Type]]
    [:caption-side
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/caption_side_Type]]
    [:color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:country
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/country_Type]]
    [:cue
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:cue-after
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:cue-before
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:direction
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/direction_Type]]
    [:display-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/display_align_Type]]
    [:elevation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/elevation_Type]]
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
    [:left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/left_Type]]
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
    [:pause
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:pause-after
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:pause-before
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:pitch
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:pitch-range
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:play-during
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
    [:relative-position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/relative_position_Type]]
    [:richness
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/right_Type]]
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
    [:speak
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:speak-header
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:speak-numeral
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/speak_numeral_Type]]
    [:speak-punctuation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:speech-rate
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/speech_rate_Type]]
    [:start-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:stress
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
    [:top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/top_Type]]
    [:unicode-bidi
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/unicode_bidi_Type]]
    [:vertical-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/vertical_align_Type]]
    [:visibility
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/visibility_Type]]
    [:voice-family
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:volume
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
   [:enum :inline-container]
   [:map
    {:closed true, :xml/value-wrapped true}
    [:alignment-adjust
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/alignment_adjust_Type]]
    [:alignment-baseline
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/alignment_baseline_Type]]
    [:auto-restore
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/auto_restore_Type]]
    [:background
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_Type]]
    [:background-attachment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_attachment_Type]]
    [:background-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_color_Type]]
    [:background-image
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:background-position-horizontal
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/background_position_horizontal_Type]]
    [:background-position-vertical
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/background_position_vertical_Type]]
    [:background-repeat
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_repeat_Type]]
    [:baseline-shift
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/baseline_shift_Type]]
    [:block-progression-dimension
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:block-progression-dimension.maximum
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/block_progression_dimension_maximum_Type]]
    [:block-progression-dimension.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:block-progression-dimension.optimum
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/block_progression_dimension_optimum_Type]]
    [:border
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_Type]]
    [:border-after-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-after-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-after-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_before_width_Type]]
    [:border-after-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-after-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-before-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-before-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-before-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_before_width_Type]]
    [:border-before-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-before-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-bottom-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-bottom-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-bottom-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_top_width_Type]]
    [:border-bottom-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-bottom-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_collapse_Type]]
    [:border-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_color_Type]]
    [:border-end-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-end-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-end-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_before_width_Type]]
    [:border-end-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-end-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-left-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-left-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-left-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_top_width_Type]]
    [:border-left-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-left-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-right-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-right-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-right-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_top_width_Type]]
    [:border-right-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-right-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-separation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_bp_ip_direction_Type]]
    [:border-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-start-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-start-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-start-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_before_width_Type]]
    [:border-start-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-start-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_multi_style_Type]]
    [:border-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-top-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-top-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-top-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_top_width_Type]]
    [:border-top-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-top-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/bottom_Type]]
    [:caption-side
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/caption_side_Type]]
    [:clip
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/clip_Type]]
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
    [:dominant-baseline
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/dominant_baseline_Type]]
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
    [:height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/height_Type]]
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
    [:inline-progression-dimension
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:inline-progression-dimension.maximum
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/block_progression_dimension_maximum_Type]]
    [:inline-progression-dimension.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:inline-progression-dimension.optimum
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/block_progression_dimension_optimum_Type]]
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
    [:keep-with-next
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-with-previous
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
    [:left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/left_Type]]
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
    [:margin-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:margin-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:margin-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:margin-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
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
    [:overflow
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/overflow_Type]]
    [:padding
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-after
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-after.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-after.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-before
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-before.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-before.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_top_Type]]
    [:padding-bottom.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-bottom.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-end
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-end.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-end.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_top_Type]]
    [:padding-left.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-left.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_top_Type]]
    [:padding-right.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-right.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-start
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-start.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-start.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_top_Type]]
    [:padding-top.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-top.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
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
    [:relative-position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/relative_position_Type]]
    [:right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/right_Type]]
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
    [:space-end
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/space_start_Type]]
    [:space-end.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:space-end.maximum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-end.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-end.optimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-end.precedence
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Force_Type]]
    [:space-start
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/space_start_Type]]
    [:space-start.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:space-start.maximum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-start.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-start.optimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-start.precedence
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Force_Type]]
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
    [:top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/top_Type]]
    [:vertical-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/vertical_align_Type]]
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
    [:width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/height_Type]]
    [:word-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:wrap-option
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/wrap_option_Type]]
    [:writing-mode
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/writing_mode_Type]]
    [:xml/value
     [:+
      [:alt
       [:ref :org.w3.www.1999.XSL.Format/marker_List]
       [:ref :org.w3.www.1999.XSL.Format/block_List]
       [:ref :org.w3.www.1999.XSL.Format/neutral_List]
       [:ref :org.w3.www.1999.XSL.Format/float_List]
       [:ref :org.w3.www.1999.XSL.Format/footnote_List]]]]]]
  [:tuple
   [:enum :multi-toggle]
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
    [:role
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
    [:source-document
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:start-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:switch-to
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
    [:vertical-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/vertical_align_Type]]
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
    [:xml/value :xml/hiccup]]]])
(def
 sch-seq
 [:alt
  [:tuple
   [:enum :bidi-override]
   [:map
    {:closed true, :xml/value-wrapped true}
    [:auto-restore
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/auto_restore_Type]]
    [:azimuth
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/azimuth_Type]]
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
    [:bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/bottom_Type]]
    [:caption-side
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/caption_side_Type]]
    [:color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:country
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/country_Type]]
    [:cue
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:cue-after
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:cue-before
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:direction
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/direction_Type]]
    [:display-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/display_align_Type]]
    [:elevation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/elevation_Type]]
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
    [:left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/left_Type]]
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
    [:pause
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:pause-after
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:pause-before
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:pitch
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:pitch-range
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:play-during
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
    [:relative-position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/relative_position_Type]]
    [:richness
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/right_Type]]
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
    [:speak
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:speak-header
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:speak-numeral
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/speak_numeral_Type]]
    [:speak-punctuation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:speech-rate
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/speech_rate_Type]]
    [:start-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:stress
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
    [:top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/top_Type]]
    [:unicode-bidi
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/unicode_bidi_Type]]
    [:vertical-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/vertical_align_Type]]
    [:visibility
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/visibility_Type]]
    [:voice-family
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:volume
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
   [:enum :inline-container]
   [:map
    {:closed true, :xml/value-wrapped true}
    [:alignment-adjust
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/alignment_adjust_Type]]
    [:alignment-baseline
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/alignment_baseline_Type]]
    [:auto-restore
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/auto_restore_Type]]
    [:background
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_Type]]
    [:background-attachment
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_attachment_Type]]
    [:background-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_color_Type]]
    [:background-image
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:background-position-horizontal
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/background_position_horizontal_Type]]
    [:background-position-vertical
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/background_position_vertical_Type]]
    [:background-repeat
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/background_repeat_Type]]
    [:baseline-shift
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/baseline_shift_Type]]
    [:block-progression-dimension
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:block-progression-dimension.maximum
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/block_progression_dimension_maximum_Type]]
    [:block-progression-dimension.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:block-progression-dimension.optimum
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/block_progression_dimension_optimum_Type]]
    [:border
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_Type]]
    [:border-after-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-after-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-after-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_before_width_Type]]
    [:border-after-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-after-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-before-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-before-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-before-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_before_width_Type]]
    [:border-before-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-before-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-bottom-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-bottom-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-bottom-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_top_width_Type]]
    [:border-bottom-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-bottom-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-collapse
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_collapse_Type]]
    [:border-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_color_Type]]
    [:border-end-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-end-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-end-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_before_width_Type]]
    [:border-end-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-end-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-left-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-left-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-left-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_top_width_Type]]
    [:border-left-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-left-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-right-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-right-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-right-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_top_width_Type]]
    [:border-right-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-right-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-separation
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_bp_ip_direction_Type]]
    [:border-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-start-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-start-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-start-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_before_width_Type]]
    [:border-start-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-start-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_multi_style_Type]]
    [:border-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_side_Type]]
    [:border-top-color
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/color_Type]]
    [:border-top-style
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_style_Type]]
    [:border-top-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_top_width_Type]]
    [:border-top-width.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:border-top-width.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:border-width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/border_margin_width_Type]]
    [:bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/bottom_Type]]
    [:caption-side
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/caption_side_Type]]
    [:clip
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/clip_Type]]
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
    [:dominant-baseline
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/dominant_baseline_Type]]
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
    [:height
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/height_Type]]
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
    [:inline-progression-dimension
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:inline-progression-dimension.maximum
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/block_progression_dimension_maximum_Type]]
    [:inline-progression-dimension.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:inline-progression-dimension.optimum
     {:xml/attr true, :optional true}
     [:ref
      :org.w3.www.1999.XSL.Format/block_progression_dimension_optimum_Type]]
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
    [:keep-with-next
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/keep_integer_Type]]
    [:keep-with-previous
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
    [:left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/left_Type]]
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
    [:margin-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:margin-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:margin-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
    [:margin-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/margin_width_Type]]
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
    [:overflow
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/overflow_Type]]
    [:padding
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-after
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-after.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-after.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-before
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-before.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-before.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-bottom
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_top_Type]]
    [:padding-bottom.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-bottom.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-end
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-end.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-end.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-left
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_top_Type]]
    [:padding-left.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-left.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_top_Type]]
    [:padding-right.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-right.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-start
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_before_Type]]
    [:padding-start.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-start.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:padding-top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/padding_top_Type]]
    [:padding-top.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:padding-top.length
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
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
    [:relative-position
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/relative_position_Type]]
    [:right
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/right_Type]]
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
    [:space-end
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/space_start_Type]]
    [:space-end.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:space-end.maximum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-end.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-end.optimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-end.precedence
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Force_Type]]
    [:space-start
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/space_start_Type]]
    [:space-start.conditionality
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/conditionality_Type]]
    [:space-start.maximum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-start.minimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-start.optimum
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/length_Type]]
    [:space-start.precedence
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/integer_Force_Type]]
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
    [:top
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/top_Type]]
    [:vertical-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/vertical_align_Type]]
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
    [:width
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/height_Type]]
    [:word-spacing
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/letter_spacing_Type]]
    [:wrap-option
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/wrap_option_Type]]
    [:writing-mode
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/writing_mode_Type]]
    [:xml/value
     [:+
      [:alt
       [:ref :org.w3.www.1999.XSL.Format/marker_List]
       [:ref :org.w3.www.1999.XSL.Format/block_List]
       [:ref :org.w3.www.1999.XSL.Format/neutral_List]
       [:ref :org.w3.www.1999.XSL.Format/float_List]
       [:ref :org.w3.www.1999.XSL.Format/footnote_List]]]]]]
  [:tuple
   [:enum :multi-toggle]
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
    [:role
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
    [:source-document
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
    [:start-indent
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/start_indent_Type]]
    [:switch-to
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.2001.XMLSchema/string]]
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
    [:vertical-align
     {:xml/attr true, :optional true}
     [:ref :org.w3.www.1999.XSL.Format/vertical_align_Type]]
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
    [:xml/value :xml/hiccup]]]])
