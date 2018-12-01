import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ArticleService } from '../../services/article.service';
@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  id: number;
  category;
  page: number;
  articles;
  constructor(private router: Router, private route: ActivatedRoute, private articleService: ArticleService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params.id;
      if (params.page == null) {
        this.page = 1;
      } else {
        this.page = params.page;
      }
      this.articleService.getCategory(this.id).subscribe(
        res => this.category = res);
      this.articleService.getArticlesByCategory(this.id, this.page).subscribe(
        res => this.articles = res);
    });

  }
  next() {
    this.router.navigateByUrl('/dummy', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/category', this.id, 'page', ++this.page]));
  }
  back() {
    this.router.navigateByUrl('/dummy', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/category', this.id, 'page', --this.page]));
  }
}
