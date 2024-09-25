package com.vijay.book.book;

import com.vijay.book.common.BaseEntity;
import com.vijay.book.feedback.Feedback;
import com.vijay.book.history.BookTransactionHistory;
import com.vijay.book.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {

    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    @Transient
    public double getRate() {
        if (this.feedbacks == null || this.feedbacks.isEmpty()) {
            return 0.0;
        }
        var rate = this.feedbacks.stream().mapToDouble(Feedback::getNote).average().orElse(0.0);
        return Math.round(rate * 10.0) / 10.0;

    }

}
