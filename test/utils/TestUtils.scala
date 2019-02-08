/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package utils

import config.AppConfig
import org.scalatest.BeforeAndAfterEach
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.i18n.{Lang, Messages, MessagesApi}
import play.api.inject.Injector
import play.api.test.FakeRequest
import uk.gov.hmrc.auth.core.AuthConnector
import uk.gov.hmrc.play.test.UnitSpec
import org.scalamock.scalatest.MockFactory
import uk.gov.hmrc.http.HeaderCarrier

import scala.concurrent.ExecutionContext


trait TestUtils extends UnitSpec with GuiceOneAppPerSuite with BeforeAndAfterEach with MockFactory {

  implicit lazy val fakeRequest = FakeRequest("GET", "/")
  lazy val injector: Injector = app.injector
  lazy val messagesApi: MessagesApi = injector.instanceOf[MessagesApi]
  implicit lazy val messages: Messages = Messages(Lang("en-GB"), messagesApi)
  implicit lazy val appConfig = injector.instanceOf[AppConfig]
  lazy val mockAuthConnector: AuthConnector = mock[AuthConnector]
  implicit lazy val executionContext: ExecutionContext = injector.instanceOf[ExecutionContext]
  implicit lazy val headerCarrier: HeaderCarrier = HeaderCarrier()
}