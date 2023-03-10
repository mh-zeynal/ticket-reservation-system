import {Option} from "./option";

export interface Permission {
  option: Option;
  isAllowed: boolean;
  permType: string;
}
