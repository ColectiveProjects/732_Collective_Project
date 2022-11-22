import {HttpClient} from "@angular/common/http";
import {Task} from "../models/task";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {BackendRequestsService} from "../backend-requests/backend-requests.service";
import {environment} from "../../environments/environment";


@Injectable({
  providedIn: 'root'
})

export class TaskService{

  constructor(private backendRequestsService: BackendRequestsService) {
  }

  getAllTasks(): Observable<Task[]> {
    return this.backendRequestsService.get(environment.apiUrl + '/task/allTasks');
  }

  postTask(task: Task) {
    return this.backendRequestsService.post(environment.apiUrl + '/task/addTasks', task);
  }
}
