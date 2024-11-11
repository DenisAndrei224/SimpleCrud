import { Component, OnInit } from '@angular/core';
import { BookService, Book } from '../book.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {
  bookForm: FormGroup;


  constructor(private fb: FormBuilder, private bookService: BookService) {
    this.bookForm = this.fb.group({
      title: [''],
      author: ['']
    });
   }

  ngOnInit(): void {
  }

  onSubmit() {
    const newBook: Book = this.bookForm.value;
    this.bookService.createBook(newBook).subscribe(response => {
      console.log('Book created:', response);
      this.bookForm.reset();
    });
  }

}
