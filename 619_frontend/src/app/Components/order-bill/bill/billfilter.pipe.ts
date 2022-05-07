import { Pipe, PipeTransform, Renderer2 } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Bill } from '../bill';

@Pipe({
  name: 'billfilter'
})
export class BillfilterPipe implements PipeTransform {
  subject=new BehaviorSubject<Bill[]>([]);
constructor(private renderer:Renderer2){}
  transform(bills: Bill[], value: HTMLInputElement):Observable< Bill[] >{
    
    this.subject.next(bills)
    this.renderer.listen(value,"input",(e) =>{
      if (!e.target.value)    this.subject.next(bills)
      let result= bills.filter(bill=>JSON.stringify(Object.values(bill)) .includes(e.target.value) ) ;
      this.subject.next(result)
    })
   return this.subject;
  }

}
