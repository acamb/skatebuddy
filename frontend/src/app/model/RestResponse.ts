export class RestResponse<T>{
  payload: T;
  ok: boolean;
  errorCode: string;
}
