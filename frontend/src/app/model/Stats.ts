import {Wheel} from "./Wheel";

export class Stats{
  lastImportedActivityDate: Date;
  currentWheel: Wheel;
  maxSpeed: number;
  avgSpeed: number;
  maxRunKM: number;
  avgRunKM: number;
  totalKM: number;
  rotationKM: number;
  autoimport: boolean;
}
