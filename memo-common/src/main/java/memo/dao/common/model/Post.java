/*
 * Copyright (C) 2010 Dimitrios Menounos
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package memo.dao.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mojo.dao.model.AuditableEntity;

@Entity
@Table(name = "memo_post")
public class Post extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	private Post parent;
	private String title;
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	public Post getParent() {
		return parent;
	}

	public void setParent(Post parent) {
		this.parent = parent;
	}

	@Column(nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Lob
	@Column(nullable = false, length = Short.MAX_VALUE)
	// http://opensource.atlassian.com/projects/hibernate/browse/HHH-2614
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
