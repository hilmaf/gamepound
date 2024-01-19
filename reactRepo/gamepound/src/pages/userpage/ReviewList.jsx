import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import ReviewBox from './ReviewBox';
import { useUserPageContext } from '../../component/context/UserPageContext';

const StyledReviewListDiv = styled.div`
    width: 800px;
    display: flex;
    flex-direction: column;
    align-items: center;
`;

const ReviewList = () => {

    const {profileVo} = useUserPageContext();

    const [reviewList, setReviewList] = useState([]); 

    const memberNo = {
        "memberNo": profileVo.no
    }

    const [activePage, setActivePage] = useState(1);
    const handlePageChange = (pageNumber) => {
        console.log(`active page is ${pageNumber}`);

        setActivePage(pageNumber);
    }

    const getReviewList = () => {
        fetch("http://127.0.0.1:8889/gamepound/userpage/review", {
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(memberNo)
        })
        .then(resp => resp.json())
        .then(data => {
            setReviewList(data.reviewList);
            cnt = data.size;
        })
    }


    let cnt;
    useEffect(()=>{
        getReviewList();
    }, [])

    

    return (
        <StyledReviewListDiv>
            {
                reviewList === null || reviewList === undefined
                ?
                <>
                </>
                :
                <>
                    {reviewList.map((item)=> (
                        <ReviewBox item={item}/>
                    ))} 
                </>
                

            }
        </StyledReviewListDiv>
    );
};

export default ReviewList;