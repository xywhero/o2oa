package com.x.cms.core.entity.element;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.StringUtils;
import org.apache.openjpa.persistence.jdbc.Index;

import com.x.base.core.entity.AbstractPersistenceProperties;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.entity.SliceJpaObject;
import com.x.base.core.entity.annotation.CheckPersist;
import com.x.base.core.entity.annotation.ContainerEntity;
import com.x.base.core.entity.annotation.Flag;
import com.x.base.core.project.annotation.FieldDescribe;
import com.x.cms.core.entity.PersistenceProperties;

@Entity
@ContainerEntity
@Table(name = PersistenceProperties.Element.TemplateForm.table, uniqueConstraints = {
		@UniqueConstraint(name = PersistenceProperties.Element.TemplateForm.table + JpaObject.IndexNameMiddle
				+ JpaObject.DefaultUniqueConstraintSuffix, columnNames = { JpaObject.IDCOLUMN,
						JpaObject.CREATETIMECOLUMN, JpaObject.UPDATETIMECOLUMN, JpaObject.SEQUENCECOLUMN }) })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TemplateForm extends SliceJpaObject {

	private static final long serialVersionUID = -1032370866037915354L;

	private static final String TABLE = PersistenceProperties.Element.TemplateForm.table;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@FieldDescribe("数据库主键,自动生成.")
	@Id
	@Column(length = length_id, name = ColumnNamePrefix + id_FIELDNAME)
	private String id = createId();

	public void onPersist() throws Exception {
		if (StringUtils.isEmpty(this.category)) {
			this.category = "未分类";
		}

	}

	/* 以上为 JpaObject 默认字段 */

	/* 更新运行方法 */

	// public static String[] FLA GS = new String[] { "id", "alias" };

	/* flag标志位 */
	/* Entity 默认字段结束 */

	public String getDataOrMobileData() {
		if (StringUtils.isNotEmpty(this.getData())) {
			return this.getData();
		} else if (StringUtils.isNotEmpty(this.getMobileData())) {
			return this.getMobileData();
		}
		return null;
	}

	public String getMobileDataOrData() {
		if (StringUtils.isNotEmpty(this.getMobileData())) {
			return this.getMobileData();
		} else if (StringUtils.isNotEmpty(this.getData())) {
			return this.getData();
		}
		return null;
	}

	@FieldDescribe("名称.")
	@Column(length = AbstractPersistenceProperties.processPlatform_name_length, name = "xname")
	@CheckPersist(allowEmpty = true)
	private String name;

	public static final String category_FIELDNAME = "category";
	@FieldDescribe("模版分类.")
	@Column(length = AbstractPersistenceProperties.processPlatform_name_length, name = "xcategory")
	@Index(name = TABLE + "_category")
	@CheckPersist(allowEmpty = false)
	private String category;

	@Flag
	@FieldDescribe("表单别名.")
	@Column(length = AbstractPersistenceProperties.processPlatform_name_length, name = "xalias")
	@CheckPersist(allowEmpty = true)
	private String alias;

	@FieldDescribe("描述.")
	@Column(length = AbstractPersistenceProperties.processPlatform_name_length, name = "xdescription")
	@CheckPersist(allowEmpty = true)
	private String description;

	@FieldDescribe("icon Base64编码后的文本.")
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(length = JpaObject.length_128K, name = "xicon")
	@CheckPersist(allowEmpty = true)
	private String icon;

	@FieldDescribe("缩略图.")
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(length = JpaObject.length_1M, name = "xoutline")
	@CheckPersist(allowEmpty = true)
	private String outline;

	@FieldDescribe("文本内容.")
	@Lob
	@Basic(fetch = FetchType.EAGER)
	// @Persistent(fetch = FetchType.EAGER)
	@Column(length = JpaObject.length_10M, name = "xdata")
	@CheckPersist(allowEmpty = true)
	private String data;

	@FieldDescribe("移动端文本内容.")
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(length = JpaObject.length_10M, name = "xmobileData")
	@CheckPersist(allowEmpty = true)
	private String mobileData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMobileData() {
		return mobileData;
	}

	public void setMobileData(String mobileData) {
		this.mobileData = mobileData;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

}