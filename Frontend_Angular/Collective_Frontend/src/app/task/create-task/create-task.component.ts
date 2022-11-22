import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {matchValidator} from "../../user/user-register-form/user-register-form.component";
import {TaskService} from "../../services/task.service";
import {Router} from "@angular/router";
import {Task} from "../../models/task";
import {first} from "rxjs";

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css']
})
export class CreateTaskComponent implements OnInit {

  //TODO category
  // categoryList: any = Object.keys(Category);

  taskCreateForm!: FormGroup;
  submitted = false;

  task: any;
  fields!: any[];
  severities: any[] = [];
  date!: Date;

  constructor(private formBuilder:FormBuilder,  private httpService: TaskService,
              private router: Router) {
  }

  ngOnInit(): void {

    this.taskCreateForm = this.formBuilder.group({
      name: [{ value: '', disabled: false} , [Validators.required,Validators.maxLength(30),Validators.minLength(1), Validators.pattern('^[a-zA-Z]+$')]],
      description: [{value: '', disabled: false}, [Validators.required, Validators.maxLength(500), Validators.minLength(200)]],
      category: [{value: '', disabled: false }, [Validators.required, Validators.maxLength(30),Validators.pattern('^\\+4(0[0-9]{9}|9[0-9]{6,13})$')]],
      targetDate: new Date(),
      status: [{value: '', disabled: false}],
    });
  }


  category: any;
  categoryList: any;

  onSubmit() {

    this.submitted = true;
    if (this.taskCreateForm.invalid) { return; }
    let task = this.taskCreateForm.value;
    task.name = '';
    this.httpService.postTask(task)
      .pipe(first())
      .subscribe({
        next: async (result) => {
          if (result.error) {
            console.log("There is an error")
          }
          if (result.message) {
            console.log("Success")
            await new Promise(f => setTimeout(f, 1500));
            this.router.navigate(["/task"]);
          }
        },
        error: () => {
          this.router.navigate(["/error"]);
        }
      })
  }
  };
