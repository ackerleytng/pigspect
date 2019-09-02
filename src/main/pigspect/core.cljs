(ns pigspect.core
  (:require [instaparse.core
             :refer-macros [defparser]]))

(defparser
  variables-parser
  "variable-definitions = variable-definition (newline variable-definition)* newline?
   variable-definition = var | portvar | ipvar

   var = 'var' whitespace variable-name whitespace var-value
   var-value = #'\\S+'

   portvar = 'portvar' whitespace variable-name whitespace portvar-value
   portvar-value = port-negation? ( port | port-group | port-any | variable-sub )
   port-any = 'any'
   port-group = '[' port-group-items ']'
   <port-group-items> = portvar-value ( ',' portvar-value )*
   port-range = #'\\d+' ':' #'\\d+'
   port-negation = '!'
   port = #'\\d+'

   ipvar = 'ipvar' whitespace variable-name whitespace ipvar-value
   ipvar-value = ip-negation? ( ipv4 | ipv4-cidr-block | ipv6 | ipv6-cidr-block | ip-group | ip-any | variable-sub )
   ip-any = 'any'
   ip-group = '[' ip-group-items ']'
   <ip-group-items> = ipvar-value ( ',' ipvar-value )*
   ip-negation = '!'
   ipv4 = #'\\d+.\\d+.\\d+.\\d+'
   ipv4-cidr-block = ipv4 '/' cidr-range

   (* Looser regex than it can be *)
   ipv6 = #'[a-fA-F0-9]{0,4}(:[a-fA-F0-9]{0,4}){1,7}'
   ipv6-cidr-block = ipv6 '/' cidr-range

   cidr-range = #'\\d+'

   variable-sub = variable-sub-regular | variable-sub-paren | variable-sub-default | variable-sub-msg
   variable-sub-regular = '$' variable-name
   variable-sub-paren = '$(' variable-name ')'
   variable-sub-default = '$(' variable-name ':-' #'[^)]' ')'
   variable-sub-msg = '$(' variable-name ':?' #'[^)]' ')'

   variable-name = #'[A-Za-z_]\\w*'
   <newline> = '\\n' | '\\r\\n'
   <whitespace> = #'\\s+'")

(defn parse-variables [s]
  (clj->js (variables-parser s)))
