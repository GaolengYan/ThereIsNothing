# ThereIsNothing
### 首次提交2018.2.22
后台爬取173acg的新闻，并保存到数据库中，并在首页显示。
已整合Spring5.0+struts2.5+hibernate5.2
数据库为mysql
### 更新2018.2.23
修改了某些已知bug

### 类说明
##### Action包下：
NewsContentAction 用于跳转首页到新闻内容页面
NewsLoadAction 用于跳转加载欢迎页面到首页新闻列表
##### Bean包下：  
Content 包括新闻名、作者、日期、内容，用于页面间传输与展示。不参与数据库交互。
Newscontent 包括原网页的地址src（主键）与内容，用于与数据库交互。
Newscover 包括新闻名、作者、日期、封面图片、以及内容网页的地址（主键），用于展示在主页新闻列表以及数据库交互。
##### Dao包下：
NewsContentDao 用于读取数据库中新闻内容
NewscoverDao 用于读取数据库中新闻封面列表
##### Spider包下：
Spider 用于爬新闻内容和新闻封面
##### Util包下：
HibernateUtil 用于获取会话，开启事务