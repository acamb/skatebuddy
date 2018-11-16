import {Wheel} from "./Wheel";

export class Activity{
  id: number;
  name: string;
  date: Date;
  distance: number;
  time: number;
  avgSpeed: number;
  maxSpeed: number;
  wheel: Wheel;
}
