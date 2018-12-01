package com.muhammadalsaied.blog.backend;

import com.muhammadalsaied.blog.backend.dao.ArticleDao;
import com.muhammadalsaied.blog.backend.dao.CategoryDao;
import com.muhammadalsaied.blog.backend.dao.TagDao;
import com.muhammadalsaied.blog.backend.dao.UserDao;
import com.muhammadalsaied.blog.backend.dto.Article;
import com.muhammadalsaied.blog.backend.dto.Category;
import com.muhammadalsaied.blog.backend.dto.Tag;
import com.muhammadalsaied.blog.backend.dto.User;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@Component
public class Commands implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private TagDao tagDao;

	@Autowired
	private ArticleDao articleDao;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setFirstName("محمد");
		user.setLastName("السعيد");
		user.setEmail("muhammadAlsaied96@gmail.com");
		user.setPassword("pass");
		user.setDescription("مطور هذا الموقع ");
		user.setRole("admin");
		user.setActive(true);
		userDao.save(user);

		Category webDesign = new Category();
		webDesign.setName("تصميم المواقع");
		categoryDao.save(webDesign);

		Category webDevelopment = new Category();
		webDevelopment.setName("برمحة المواقع");
		categoryDao.save(webDevelopment);

		Category mobileApps = new Category();
		mobileApps.setName("تطبيقات الموبايل");
		categoryDao.save(mobileApps);

		Tag js = new Tag();
		js.setName("javascript");
		tagDao.save(js);

		Tag java = new Tag();
		java.setName("java");
		tagDao.save(java);

		Tag php = new Tag();
		php.setName("php");
		tagDao.save(php);

		Tag html = new Tag();
		html.setName("html");
		tagDao.save(html);

		Tag css = new Tag();
		css.setName("css");
		tagDao.save(css);

		Tag jquery = new Tag();
		jquery.setName("jquery");
		tagDao.save(jquery);

		Tag bootstrab = new Tag();
		bootstrab.setName("bootstrsb");
		tagDao.save(bootstrab);

		Tag laravel = new Tag();
		laravel.setName("laravel");
		tagDao.save(laravel);

		Tag android = new Tag();
		android.setName("android");
		tagDao.save(android);
	
		Tag angular = new Tag();
		angular.setName("angular");
		tagDao.save(angular);

		Article article = new Article();
		article.setTitle("هل انتهت الجي كويري؟");
		article.setViews(10000l);

		article.setContent(
				"لكن لا بد أن أوضح لك أن كل هذه الأفكار المغلوطة حول استنكار  النشوة وتمجيد الألم نشأت بالفعل، وسأعرض لك التفاصيل لتكتشف حقيقة وأساس تلك السعادة البشرية، فلا أحد يرفض أو يكره أو يتجنب الشعور بالسعادة، ولكن بفضل هؤلاء الأشخاص الذين لا يدركون بأن السعادة لا بد أن نستشعرها بصورة أكثر عقلانية ومنطقية فيعرضهم هذا لمواجهة الظروف الأليمة، وأكرر بأنه لا يوجد من يرغب في الحب ونيل المنال ويتلذذ بالآلام، الألم هو الألم ولكن نتيجة لظروف ما قد تكمن السعاده فيما نتحمله من كد وأسي.\n"
						+ "\n"
						+ "و سأعرض مثال حي لهذا، من منا لم يتحمل جهد بدني شاق إلا من أجل الحصول على ميزة أو فائدة؟ ولكن من لديه الحق أن ينتقد شخص ما أراد أن يشعر بالسعادة التي لا تشوبها عواقب أليمة أو آخر أراد أن يتجنب الألم الذي ربما تنجم عنه بعض المتعة ؟ \n"
						+ "علي الجانب الآخر نشجب ونستنكر هؤلاء الرجال المفتونون بنشوة اللحظة الهائمون في رغباتهم فلا يدركون ما يعقبها من الألم والأسي المحتم، واللوم كذلك يشمل هؤلاء الذين أخفقوا في واجباتهم نتيجة لضعف إرادتهم فيتساوي مع هؤلاء الذين يتجنبون وينأون عن تحمل الكدح والألم .\n"
						+ "	       ");
		article.setCategory(webDesign);
		article.addTag(js);
		article.addTag(jquery);
		article.setDateCreated(new Date());
		article.setImageUrl("assets\\img\\1.jpg");
		article.setUser(user);
		article.setActive(true);
		articleDao.save(article);

		article = new Article();
		article.setTitle("ما هو اللارافيل؟");
		article.setViews(1000l);
		article.setContent(
				"لكن لا بد أن أوضح لك أن كل هذه الأفكار المغلوطة حول استنكار  النشوة وتمجيد الألم نشأت بالفعل، وسأعرض لك التفاصيل لتكتشف حقيقة وأساس تلك السعادة البشرية، فلا أحد يرفض أو يكره أو يتجنب الشعور بالسعادة، ولكن بفضل هؤلاء الأشخاص الذين لا يدركون بأن السعادة لا بد أن نستشعرها بصورة أكثر عقلانية ومنطقية فيعرضهم هذا لمواجهة الظروف الأليمة، وأكرر بأنه لا يوجد من يرغب في الحب ونيل المنال ويتلذذ بالآلام، الألم هو الألم ولكن نتيجة لظروف ما قد تكمن السعاده فيما نتحمله من كد وأسي.\n"
						+ "\n"
						+ "و سأعرض مثال حي لهذا، من منا لم يتحمل جهد بدني شاق إلا من أجل الحصول على ميزة أو فائدة؟ ولكن من لديه الحق أن ينتقد شخص ما أراد أن يشعر بالسعادة التي لا تشوبها عواقب أليمة أو آخر أراد أن يتجنب الألم الذي ربما تنجم عنه بعض المتعة ؟ \n"
						+ "علي الجانب الآخر نشجب ونستنكر هؤلاء الرجال المفتونون بنشوة اللحظة الهائمون في رغباتهم فلا يدركون ما يعقبها من الألم والأسي المحتم، واللوم كذلك يشمل هؤلاء الذين أخفقوا في واجباتهم نتيجة لضعف إرادتهم فيتساوي مع هؤلاء الذين يتجنبون وينأون عن تحمل الكدح والألم .\n"
						+ "	       ");
		article.setCategory(webDevelopment);
		article.addTag(laravel);
		article.addTag(php);
		article.setDateCreated(new Date());
		article.setImageUrl("assets\\img\\2.jpg");
		article.setUser(user);
		article.setActive(true);
		articleDao.save(article);

		article = new Article();
		article.setTitle("مقدمة في برمجة تطبيقات الاندرويد");
		article.setViews(2000l);
		article.setContent(
				"لكن لا بد أن أوضح لك أن كل هذه الأفكار المغلوطة حول استنكار  النشوة وتمجيد الألم نشأت بالفعل، وسأعرض لك التفاصيل لتكتشف حقيقة وأساس تلك السعادة البشرية، فلا أحد يرفض أو يكره أو يتجنب الشعور بالسعادة، ولكن بفضل هؤلاء الأشخاص الذين لا يدركون بأن السعادة لا بد أن نستشعرها بصورة أكثر عقلانية ومنطقية فيعرضهم هذا لمواجهة الظروف الأليمة، وأكرر بأنه لا يوجد من يرغب في الحب ونيل المنال ويتلذذ بالآلام، الألم هو الألم ولكن نتيجة لظروف ما قد تكمن السعاده فيما نتحمله من كد وأسي.\n"
						+ "\n"
						+ "و سأعرض مثال حي لهذا، من منا لم يتحمل جهد بدني شاق إلا من أجل الحصول على ميزة أو فائدة؟ ولكن من لديه الحق أن ينتقد شخص ما أراد أن يشعر بالسعادة التي لا تشوبها عواقب أليمة أو آخر أراد أن يتجنب الألم الذي ربما تنجم عنه بعض المتعة ؟ \n"
						+ "علي الجانب الآخر نشجب ونستنكر هؤلاء الرجال المفتونون بنشوة اللحظة الهائمون في رغباتهم فلا يدركون ما يعقبها من الألم والأسي المحتم، واللوم كذلك يشمل هؤلاء الذين أخفقوا في واجباتهم نتيجة لضعف إرادتهم فيتساوي مع هؤلاء الذين يتجنبون وينأون عن تحمل الكدح والألم .\n"
						+ "	       ");
		article.setCategory(mobileApps);
		article.addTag(java);
		article.addTag(android);
		article.setDateCreated(new Date());
		article.setImageUrl("assets\\img\\3.jpg");
		article.setUser(user);
		article.setActive(true);
		articleDao.save(article);

		article = new Article();
		article.setViews(2000l);
		article.setTitle("ما الفرق بين الاصداريين الثالث والرابع من البوتستراب؟");
		article.setContent(
				"لكن لا بد أن أوضح لك أن كل هذه الأفكار المغلوطة حول استنكار  النشوة وتمجيد الألم نشأت بالفعل، وسأعرض لك التفاصيل لتكتشف حقيقة وأساس تلك السعادة البشرية، فلا أحد يرفض أو يكره أو يتجنب الشعور بالسعادة، ولكن بفضل هؤلاء الأشخاص الذين لا يدركون بأن السعادة لا بد أن نستشعرها بصورة أكثر عقلانية ومنطقية فيعرضهم هذا لمواجهة الظروف الأليمة، وأكرر بأنه لا يوجد من يرغب في الحب ونيل المنال ويتلذذ بالآلام، الألم هو الألم ولكن نتيجة لظروف ما قد تكمن السعاده فيما نتحمله من كد وأسي.\n"
						+ "\n"
						+ "و سأعرض مثال حي لهذا، من منا لم يتحمل جهد بدني شاق إلا من أجل الحصول على ميزة أو فائدة؟ ولكن من لديه الحق أن ينتقد شخص ما أراد أن يشعر بالسعادة التي لا تشوبها عواقب أليمة أو آخر أراد أن يتجنب الألم الذي ربما تنجم عنه بعض المتعة ؟ \n"
						+ "علي الجانب الآخر نشجب ونستنكر هؤلاء الرجال المفتونون بنشوة اللحظة الهائمون في رغباتهم فلا يدركون ما يعقبها من الألم والأسي المحتم، واللوم كذلك يشمل هؤلاء الذين أخفقوا في واجباتهم نتيجة لضعف إرادتهم فيتساوي مع هؤلاء الذين يتجنبون وينأون عن تحمل الكدح والألم .\n"
						+ "	       ");
		article.setCategory(webDesign);
		article.addTag(bootstrab);
		article.addTag(css);
		article.setDateCreated(new Date());
		article.setImageUrl("assets\\img\\4.jpg");
		article.setUser(user);
		article.setActive(true);
		articleDao.save(article);

		article = new Article();
		article.setTitle("مميزات الاصدار السابع من انجولار");
		article.setViews(1000l);
		article.setContent(
				"لكن لا بد أن أوضح لك أن كل هذه الأفكار المغلوطة حول استنكار  النشوة وتمجيد الألم نشأت بالفعل، وسأعرض لك التفاصيل لتكتشف حقيقة وأساس تلك السعادة البشرية، فلا أحد يرفض أو يكره أو يتجنب الشعور بالسعادة، ولكن بفضل هؤلاء الأشخاص الذين لا يدركون بأن السعادة لا بد أن نستشعرها بصورة أكثر عقلانية ومنطقية فيعرضهم هذا لمواجهة الظروف الأليمة، وأكرر بأنه لا يوجد من يرغب في الحب ونيل المنال ويتلذذ بالآلام، الألم هو الألم ولكن نتيجة لظروف ما قد تكمن السعاده فيما نتحمله من كد وأسي.\n"
						+ "\n"
						+ "و سأعرض مثال حي لهذا، من منا لم يتحمل جهد بدني شاق إلا من أجل الحصول على ميزة أو فائدة؟ ولكن من لديه الحق أن ينتقد شخص ما أراد أن يشعر بالسعادة التي لا تشوبها عواقب أليمة أو آخر أراد أن يتجنب الألم الذي ربما تنجم عنه بعض المتعة ؟ \n"
						+ "علي الجانب الآخر نشجب ونستنكر هؤلاء الرجال المفتونون بنشوة اللحظة الهائمون في رغباتهم فلا يدركون ما يعقبها من الألم والأسي المحتم، واللوم كذلك يشمل هؤلاء الذين أخفقوا في واجباتهم نتيجة لضعف إرادتهم فيتساوي مع هؤلاء الذين يتجنبون وينأون عن تحمل الكدح والألم .\n"
						+ "	       ");
		article.setCategory(webDesign);
		article.addTag(angular);
		article.addTag(js);
		article.setDateCreated(new Date());
		article.setImageUrl("assets\\img\\5.jpg");
		article.setUser(user);
		article.setActive(true);
		articleDao.save(article);
	}
}
