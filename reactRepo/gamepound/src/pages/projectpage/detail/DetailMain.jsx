import React from 'react';
import CommunityPage from "./CommunityPage";
import StoryPage from "./StoryPage";
import UpdatePage from "./UpdatePage";
import { Route, Routes } from 'react-router-dom';

const DetailMain = () => {
    return (<>
        <h1>하하</h1>




        <Routes>
            <Route path='/community' element={<CommunityPage/>}></Route>
            <Route path='/story' element={<StoryPage/>}></Route>
            <Route path='/update' element={<UpdatePage/>}></Route>
            
        </Routes>




















    </>);
};

// //////////////////////////////////////////////////////////
/*




const StyledAllDiv = styled.div`
    width: 100%;
    .inner {
        width: 1200px;
        margin: 0 auto;
    }
`;

const StyledProjectDetailDiv = styled.div`
    display: flex;
    flex-direction: column;
    height: auto;
    margin-bottom: 40px;
    & .inner div:nth-child(1){
        width: 100%;
        margin-top: 50px;
        & > div{
            display: flex;
            justify-content: center;
            align-items: center;
            & > div{
                width: auto;
                background-color: #a1a1a115;
                border: 0.5px solid #8888886a;
                border-radius: 4px;
                padding: 7px;
                font-size: 14px;
            }
        }
        & > h1{
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }
    }
    & .inner div:nth-child(2){
        padding-top: 50px;
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-columns: 3fr 2fr;
        grid-template-rows: 1fr;
        & > img{
            background-color: black;
        }
        & > ul{
            width: 100%;
            margin-left: 30px;
            & > li:nth-child(2n){
                font-size: 40px;
                margin-bottom: 20px;
                & > span{
                    font-size: 16px;
                }
                & > span:nth-child(2){
                    font-size: 20px;
                    margin-left: 13px;
                }
                
            }
            & > li > table{
                width: 85%;
                border-top: 1px solid #ececec;
                
                & > tbody > tr > td:nth-child(2){
                    padding-left: 25px;
                    padding-top: 8px;
                }
            }
            & > li > button{
                width: 85%;
                height: 60px;
                font-size: 16px;
                color: white;
                background-color: #f05a5a;
                font-weight: 500;
                border-radius: 5px;
                margin-top: 40px;
            }
            & > li:last-child{
                margin: 0px;
            }
        }
    }
`;
const StyledProjectDetailNaviDiv = styled.div`
    width: 100%;
    border-top: 1px solid #ececec;
    border-bottom: 1px solid #ececec;
    height: 40px;
    display: flex;
    align-items: center;
    position: sticky;
    top: 126px;
    z-index: 9;
    background-color: #fff;
    box-shadow: 0 8px 15px 1px rgba(0, 0, 0, .1);
    & > div > div{
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-rows: 1fr;
        grid-template-columns: 1fr 1fr 1fr 6fr;
        grid-auto-flow: column;
        place-items: center center;
        font-size: 16px;
    }
`;

const StyledProjectSelectDiv = styled.div`
    width: 100%;
    display: flex;
    justify-content: center;
    & > div{
        width: 1200px;
        display: grid;
        grid-template-columns: 7fr 3fr;
        grid-template-rows: 1fr;
    }
`;


const PrelaunchDetailMain = () => {
    return (<StyledAllDiv>
        <StyledProjectDetailDiv>
            <div className="inner">
                <div>
                    <div><div>카테고리 명</div></div>
                    <h1>프로젝트 제목</h1>
                </div>            
                <div>
                    <img src="" alt="프로젝트 대표 이미지" />
                    <ul>
                        <li>모인금액</li>
                        <li>100,000,000 <span>원</span><span>21476%</span></li>
                        <li>남은시간</li>
                        <li>22 <span>일</span></li>
                        <li>후원자</li>
                        <li>2,675 <span>명</span></li>
                        <li>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>목표금액</td>
                                        <td>500,000원</td>
                                    </tr>
                                    <tr>
                                        <td>펀딩 기간</td>
                                        <td>2024.01.03~2024.01.31 <span>22일 남음</span></td>
                                    </tr>
                                    <tr>
                                        <td>결제</td>
                                        <td>목표금액 달성시 2024.02.01에 결제 진행</td>
                                    </tr>
                                </tbody>
                            </table>
                        </li>
                        <li><button>이 프로젝트 후원하기</button></li>
                    </ul>
                </div>
            </div>
        </StyledProjectDetailDiv>
        <StyledProjectDetailNaviDiv>
            <div className="inner">
                <div>
                    <span><Link to="/project/detail/prelaunch/story">프로젝트 계획</Link></span>
                    <span><Link to="/project/detail/prelaunch/update">업데이트</Link></span>
                    <span><Link to="/project/detail/prelaunch/community/">커뮤니티</Link></span>
                </div>
            </div>
        </StyledProjectDetailNaviDiv>
        <StyledProjectSelectDiv>
            <div>
                <Routes>
                    <Route path='/story' element={<PrelaunchStoryPage/>}></Route>
                    <Route path='/update' element={<PrelaunchUpdatePage/>}></Route>
                </Routes>   
                <div>리워드 구간</div>
            </div>
        </StyledProjectSelectDiv>
        <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
    </StyledAllDiv>);
};
*/
/////////////////////////////////////////////////////////////








export default DetailMain;