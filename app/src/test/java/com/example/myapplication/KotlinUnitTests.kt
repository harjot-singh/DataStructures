package com.example.myapplication

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.functions.Consumer
import io.reactivex.functions.Predicate
import io.reactivex.subjects.PublishSubject
import org.junit.Test
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt
import kotlin.math.sin

class KotlinUnitTests {
    @Test
    fun testSample() {
        Observable.create<String> { emitter ->
            emitter.onNext("1")
            emitter.onComplete()
            emitter.onNext("?")
        }.subscribe(Consumer { it -> print(it) })
    }

    @Test
    fun testSample2() {
        val publishSubject = PublishSubject.create<Int>()
        publishSubject.onNext(9)
        publishSubject
            .map { it*2 }
            .filter { it>100 }
            .subscribe(Consumer { println(it) })

        publishSubject.onNext(8788)
        publishSubject.onNext(7)

    }

    @Test
    fun testList() {

        val list = listOf<Sample>(
            Sample("Har"),
            Sample("sing")
        )


    }

    class Sample(val name: String) {

    }

    @Test
    fun testSampleIgnoreElements() {
        val publishSubject = PublishSubject.create<Int>()
        publishSubject.ignoreElements()
            .subscribe { print(" you are out") }
        publishSubject.onNext(2)
        publishSubject.onNext(3)

        publishSubject.onComplete()
    }

    @Test
    fun testSampleElemntAt() {
        /*Observable.fromIterable(listOf(1,2,3))
            .elementAt(2)
            .defaultIfEmpty(8)
            .subscribe { println(it) }*/

        /*Observable.fromIterable(listOf(1,2,3))
            .elementAt(2)
            .
            .subscribe { println(it) }*/

        /*val pubsubject = PublishSubject.create<Int>()
        pubsubject.elementAt(2)
            .subscribe { println(it) }
        pubsubject.onNext(2)
        pubsubject.onNext(4)
        pubsubject.onNext(6)*/
    }

    @Test
    fun testSampleSkipAt() {
        Observable.just(4,6,7)
            .skip(7)
            .subscribe(Consumer { print(it) })

        Observable.fromIterable(listOf(1,2,7,9))
            .flatMap { Observable.just("a","b")}
            .subscribe{ println(it)}
    }

    @Test
    fun testFilterAndSwitchIfEmptyOperator() {
        Observable.fromIterable(listOf(Sample("hsedd")))
            .filter(Predicate { it.name.length > 3 })
            .map { it.name }
            .switchIfEmpty(Observable.just("lol","hahahah"))
            .subscribe { println(it) }

        Observable.fromIterable(listOf(Sample("hsedd")))
            .filter(Predicate { it.name.length > 6 })
            .map { it.name }
            .switchIfEmpty(Observable.just("lol","hahahah"))
            .subscribe { println(it) }

    }


    // Opposite to filter ,which allows if Predicate is true
    //this basically skips until it becomes false, the moment its conditions satisfies it allows all elments to pass thru without checking the condition
    @Test
    fun testSkipWhile() {

        Observable.just(2,3,4,0,500,8)
            .skipWhile(Predicate { it > 1 })
            .subscribe(Consumer { println(it) })
    }

    @Test
    fun testSkipUntil() {
        val subject = PublishSubject.create<Int>()
        val trigger = PublishSubject.create<Int>()

        subject.skipUntil(trigger)
            .subscribe(Consumer { print(it) })

        subject.onNext(3)
        subject.onNext(5)
        trigger.onNext(4)
        subject.onNext(6)
        subject.onNext(4)

    }

    @Test
    fun testSampleessd() {
        val list = listOf<Sample>(
            Sample("Har"),
            Sample("sing")
        )

        val single = Single.create<List<Sample>> {  emitter ->
            emitter.onSuccess(list)
        }

        single.toObservable()
            .flatMap { Observable.fromIterable(it) }
            .map { it.name }
            .first("hshsbdhb")
            .doOnSuccess { print(it) }
            .subscribe()


        val abc = returnMayBe()
            .map { it* 4 }
            .subscribe(Consumer { print(it)  }, Consumer { print(it.message) })

    }


    fun returnObservable(): Observable<Int> {
        return  Observable.just(8,9,3)
            .filter{it > 3}
    }

    fun returnMayBe() : Maybe<Int>{
        return Single.just(5)
            .filter(Predicate { it > 3 })
            .defaultIfEmpty(67)
    }

    @Test
    fun testTakeUntil() {
        Observable.just(2,3,4)
            .takeWhile(Predicate { it > 2 })
            .subscribe(Consumer { println(it) })

        /*Observable.just(2,3,4)
            .take(5)
            .subscribe(Consumer { println(it) })*/

        Observable.just(2,3,4,5)

    }


    @Test
    fun checkIfNotEmpty() {
        val list = listOf<Int>(1,2,3)
        //val list = emptyList<Int>()
        when {
            list?.isNotEmpty() -> list.forEach { println(it*3) }
            else -> println("Hello")
        }
//        println(list.isNullOrEmpty())
//        println(Math.ceil(12.3))
//        println(Math.ceil(12.6))
//        println(Math.floor(12.3))
//        println(Math.floor(12.3))
        println(12.3.roundToInt())
        println(12.6.roundToInt())
        println(12.6.toInt())
        println(12.99.toInt())

    }

    @Test
    fun testSampleMap() {
        val Obs1 = Observable.interval(5,TimeUnit.SECONDS)
        val Obs2 = Observable.interval(8,TimeUnit.SECONDS)

    }

    @Test
    fun testSampleList() {
        val list = mutableListOf<String>()
        list.add("23")
        list.add("34")
        val list2 = mutableListOf<Int>()
        list.mapTo(list2) {
            it.toInt()+1
        }
        print(list2)


        list.map {
            it + " 01"
            print(it)
        }
        print(list)

    }



}