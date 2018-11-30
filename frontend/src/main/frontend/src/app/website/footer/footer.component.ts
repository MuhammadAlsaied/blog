import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../services/article.service';


@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  constructor(private articleService: ArticleService) { }
  categories;
  ngOnInit() {
    this.articleService.getCategories().subscribe(res => this.categories = res);
  }

}
