import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../services/article.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor(private articleService: ArticleService) { }
  categories;
  ngOnInit() {
    this.articleService.getCategories().subscribe(res => this.categories = res);
  }
}
