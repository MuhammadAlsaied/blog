import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ArticleService } from '../../services/article.service';

@Component({
  selector: 'app-tag',
  templateUrl: './tag.component.html',
  styleUrls: ['./tag.component.css']
})
export class TagComponent implements OnInit {

  id: number;
  tag;
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
    });
    this.articleService.getTag(this.id).subscribe(
      res => this.tag = res);
    this.articleService.getArticlesByTag(this.id, this.page).subscribe(
      res => this.articles = res);
  }
  next() {
    this.router.navigateByUrl('/dummy', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/tag', this.id, 'page', ++this.page]));
  }
  back() {
    this.router.navigateByUrl('/dummy', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/tag', this.id, 'page', --this.page]));
  }
}
