import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useUserPageContext } from '../../component/context/UserPageContext';

const StyledReviewStatsDiv = styled.div`
    color: var(--black-color);
    width: 280px;
    height: 200px;
    display: flex;
    background-color: whitesmoke;
    border-radius: 5px;
    flex-direction: column;
    align-items: center;

    & > .rating_avg {
        padding-top: 30px;
        padding-bottom: 35px;
        display: flex;
        flex-direction: column;
        align-items: center;

        & > #title {
            font-size: 16px;
            font-weight: 500;

            & > span {
                font-weight: 300;
            }
        }

        & > #avg {
            font-size: 32px;
            color: var(--red-color);
        }
    }

    & > ul {
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 13px;

        & > li {
            padding-left: 10px;
            padding-bottom: 5px;

            & > #rating {
                padding-right: 5px;
                color: rgb(0, 0, 0, 0.7);
            }
            
            & > #cnt {
                padding-right: 5px;
                color: rgb(0, 0, 0, 0.7);
            }
        }
    }
`;

const ReviewStats = () => {

    const {profileVo} = useUserPageContext();

    const memberNo = {
        "memberNo": profileVo.no
    }

    const [statVo, setStatVo] = useState([]);

    useEffect(()=> {
        fetch("http://127.0.0.1:8889/gamepound/userpage/review/stat", {
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(memberNo)
        })
        .then(resp => resp.json())
        .then(data => {
            console.log(data);
            setStatVo(data);
            console.log(statVo);
        })
    }, [])

    return (
        <StyledReviewStatsDiv>
            {
                statVo === null || statVo === undefined
                ?
                <></>
                :
                <>
                    <div className='rating_avg'>
                        <div id='title'>{profileVo.name}<span> 님의 프로젝트 만족도</span></div>
                        <div id='avg'>{statVo.ratingAvg}</div>
                    </div>
                    <ul>
                        <li><span id='rating'>1점</span><span id='cnt'>{statVo.countRating1}개</span></li>
                        <li><span id='rating'>2점</span><span id='cnt'>{statVo.countRating2}개</span></li>
                    </ul>
                    <ul>
                        <li><span id='rating'>3점</span><span id='cnt'>{statVo.countRating3}개</span></li>
                        <li><span id='rating'>4점</span><span id='cnt'>{statVo.countRating4}개</span></li>
                        <li><span id='rating'>5점</span><span id='cnt'>{statVo.countRating5}개</span></li>
                    </ul>
                </>
            }

            
        </StyledReviewStatsDiv>
    );
};

export default ReviewStats;