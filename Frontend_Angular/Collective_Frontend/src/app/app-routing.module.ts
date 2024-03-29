import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./core/authentication/components/login/login.component";
import {UserRegisterFormComponent} from "./user/user-register-form/user-register-form.component";
import {AssignUnassignTaskComponent} from "./task/assign-unassign-task/assign-unassign-task.component";
import {AddCategoryComponent} from "./category/add-category/add-category.component";
import {CreateTaskComponent} from "./task/create-task/create-task.component";
import {HomeComponent} from "./home/home/home.component";
import {LoginActivateGuard} from "./core/authentication/components/guards/login-activate.guard";
import {UnmarkedTaskListComponent} from "./task/unmarked-task-list/unmarked-task-list.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  // {path: 'home', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {
    path: 'register',
    component: UserRegisterFormComponent,
    pathMatch: 'full'
  },
  {
    path: 'app-home',
    component: HomeComponent,
    canActivate: [LoginActivateGuard],
    pathMatch: 'full'
  },
  {
    path: 'assign-unassign-task',
    component: AssignUnassignTaskComponent,
    canActivate: [LoginActivateGuard],
    pathMatch: 'full'
  },
  {
    path: 'app-add-category',
    component: AddCategoryComponent,
    canActivate: [LoginActivateGuard],
    pathMatch: 'full'
  },
  {
    path: 'app-create-task',
    component: CreateTaskComponent,
    canActivate: [LoginActivateGuard],
    pathMatch: 'full'
  },
  {
    path: 'task-list',
    component: UnmarkedTaskListComponent,
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
