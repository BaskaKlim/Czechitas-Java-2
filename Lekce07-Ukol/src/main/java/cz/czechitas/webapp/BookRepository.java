
package cz.czechitas.webapp;

import java.util.*;
import java.util.concurrent.*;
import sun.rmi.runtime.*;

public class BookRepository {

    private Long sequence = 1L;

    private List<Book> library = new CopyOnWriteArrayList<>(Arrays.asList(
            new Book(sequence++,
                    "Stephen Hawking",
                    "Brief Answers To The Big Questions",
                    "A Brief History of Time: From the Big Bang to Black Holes is a popular-science book on cosmology (the study of the origin and evolution of the universe) by British physicist Stephen Hawking. It was first published in 1988. Hawking wrote the book for readers who have no prior knowledge of the universe and people who are just interested in learning something new. In A Brief History of Time, Hawking writes in non-technical terms about the structure,origin, development and eventual fate of the Universe, which is the object of study of astronomy and modern physics. He talks about basic concepts like space and time, basic building blocks that make up the Universe (such as quarks) and the fundamental forces that govern it (such as gravity)."
            ),
            new Book(sequence++,
                    "Brian Christian",
                    "Algorithms to Live By ",
                    "A fascinating exploration of how insights from computer algorithms can be applied to our everyday lives, helping to solve common decision-making problems and illuminate the workings of the human mind. All our lives are constrained by limited space and time, limits that give rise to a particular set of problems. What should we do, or leave undone, in a day or a lifetime? How much messiness should we accept? What balance of new activities and familiar favorites is the most fulfilling? These may seem like uniquely human quandaries, but they are not: computers, too, face the same constraints, so computer scientists have been grappling with their version of such issues for decades. And the solutions they've found have much to teach us."
            ),

            new Book(sequence++,
                    "Daniel Kahneman",
                    "Thinking, Fast and Slow",
                    "The New York Times Bestseller, acclaimed by author such as Freakonomics co- author Steven D. Levitt, Black Swan author Nassim Nicholas Taleb and Nudge co- author Richard Thaler, Thinking Fast and Slow offers a whole new look at the way our minds work, and how we make decisions.Why is there more chance we'll believe something if it's in a bold type face? Why are judges more likely to deny parole before lunch? Why do we assume a good-looking person will be more competent? The answer lies in the two ways we make choices: fast, intuitive thinking, and slow, rational thinking. This book reveals how our minds are tripped up by error and prejudice (even when we think we are being logical), and gives you practical techniques for slower,smarter thinking."
            ),

            new Book(sequence++,
                    "Daniel Coyle",
                    "The Talent Code",
                    "In The Talent Code, award-winning journalist Daniel Coyle draws on cutting-edge research to reveal that, far from being some abstract mystical power fixed at birth, ability really can be created and nurtured. In the process, he considers talent at work in venues as diverse as a music school in Dallas and a tennis academy near Moscow to demostrate how the wiring of our brains can be transformed by the way we approach particular tasks. He explains what is really going on when apparently unremarkable people suddenly make a major leap forward. He reveals why some teaching methods are so much more effective than others. Above all, he shows how all of us can achieve our full potential if we set about training our brains in the right way."
            ),

            new Book(sequence++,
                    "Charles Duhigg",
                    "The Power of Habit",
                    "In The Power of Habit, award-winning New York Times business reporter Charles Duhigg takes us to the thrilling edge of scientific discoveries that explain why habits exist and how they can be changed. With penetrating intelligence and an ability to distill vast amounts of information into engrossing narratives, Duhigg brings to life a whole new understanding of human nature and its potential for transformation. Along the way we learn why some people and companies struggle to change, despite years of trying, while others seem to remake themselves overnight. "
            ),
            new Book(sequence++,
                    "Lawrence Levy",
                    "To Pixar and Beyond",
                    "After Steve Jobs was unceremoniously dismissed from Apple, he turned his attention to a little-known graphics art company that he owned called Pixar. One day, out of the blue, Jobs called Lawrence Levy, a Harvard-trained lawyer and Silicon Valley executive to whom he had never spoken before, in the hope of persuading Levy to help him get Pixar on the right track. What Levy found in Pixar was a company on the verge of failure. To Pixar and Beyond is the extraordinary story of what happened next: How Levy, working closely with Jobs and the Pixar team, produced and implemented a highly improbable roadmap that transformed the sleepy graphics art studio into one of Hollywood’s greatest success stories. "
            ),
            new Book(sequence++,
                    "Kim Scott",
                    "Radical Candor",
                    "If you don't have anything nice to say then don't say anything at all... right? While this advice may work for home life, as Kim Scott has seen first hand, it is a disaster when adopted by managers in the work place. Scott earned her stripes as a highly successful manager at Google before moving to Apple where she developed a class on optimal management. Radical Candor draws directly on her experiences at these cutting edge companies to reveal a new approach to effective management that delivers huge success by inspiring teams to work better together by embracing fierce conversations. "
            ),
            new Book(sequence++,
                    "J.D. Salinger",
                    "The Catcher in the Rye",
                    "With Love and Squalor, will not be surprised by the fact that his first novel is fully of children. The hero-narrator of THE CATCHER IN THE RYE is an ancient child of sixteen, a native New Yorker named Holden Caulfield. Through circumstances that tend to preclude adult, secondhand description, he leaves his prep school in Pennsylvania and goes underground in New York City for three days. The boy himself is at once too simple and too complex for us to make any final comment about him or his story. Perhaps the safest thing we can say about Holden is that he was born in the world not just strongly attracted to beauty but, almost, hopelessly impaled on it.  "
            )
    ));

    public List showLibrary() {
        return library;
    }

    private int getIndexViaNumber(Long keyNumber) {
        for (int i = 0; i < library.size(); i++) {
            Book b = library.get(i);
            if (b.getKeyNumber().equals(keyNumber)) {
                return i;
            }
        }
        return -1;
    }

    public Book showBookDetail(Long keyNumber) {
        int index = getIndexViaNumber(keyNumber);
        return library.get(index);
    }

    public void deleteBook(Long keyNumber) {
        int index = getIndexViaNumber(keyNumber);
        library.remove(index);

    }
    
}