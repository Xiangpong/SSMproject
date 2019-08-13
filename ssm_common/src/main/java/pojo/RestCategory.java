package pojo;

import java.util.List;

public class RestCategory {

    private List<CategoriesBean> categories;

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class CategoriesBean {
        /**
         * cat_id : 1
         * name : 父级分类名称
         * sub_categories : [{"cat_id":"2","name":"java se"},{"cat_id":"3","name":"java ee"}]
         */

        private String cat_id;
        private String name;
        private List<SubCategoriesBean> sub_categories;

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubCategoriesBean> getSub_categories() {
            return sub_categories;
        }

        public void setSub_categories(List<SubCategoriesBean> sub_categories) {
            this.sub_categories = sub_categories;
        }

        public static class SubCategoriesBean {
            /**
             * cat_id : 2
             * name : java se
             */

            private String cat_id;
            private String name;

            public String getCat_id() {
                return cat_id;
            }

            public void setCat_id(String cat_id) {
                this.cat_id = cat_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
