import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ArticleService } from '../../services/article.service';
import { DOCUMENT } from '@angular/platform-browser';
import { Inject } from '@angular/core';


@Component({
    selector: 'app-article',
    templateUrl: './article.component.html',
    styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
    id: number;
    article;
    image = '';
    url = '';
    constructor(@Inject(DOCUMENT) document: any, private router: Router,
        private route: ActivatedRoute, private articleService: ArticleService) { }
    ngOnInit() {
        this.url = document.location.href;
        this.route.params.subscribe(params => {
            this.id = params.id;
        });
        this.articleService.getArticle(this.id).subscribe(
            res => this.handleResponse(res));
        this.articleService.incrementArticleviews(this.id);
    }

    handleResponse(res) {
        this.article = res;
        for (let i = 0; i < this.article.imageUrl.length; i++) {
            const c = this.article.imageUrl.charAt(i);
            if (c === '\\') {
                this.image = this.image + '\\\\';
            } else {
                this.image = this.image + c;
            }
        }
    }
    openWindow(link) {
        window.open(link, '_blank', 'location=yes,height=570,width=520,scrollbars=yes,status=yes');
    }
}
